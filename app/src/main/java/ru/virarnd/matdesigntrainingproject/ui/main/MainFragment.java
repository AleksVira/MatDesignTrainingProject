package ru.virarnd.matdesigntrainingproject.ui.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import ru.virarnd.matdesigntrainingproject.R;
import ru.virarnd.matdesigntrainingproject.common.MainContract;

public class MainFragment extends Fragment implements MainContract.MainFragmentView {

    private static final String TAG = MainFragment.class.getSimpleName();
    private OnFragmentInteractionListener interactionListener;
    private Button btnGo;
    private Button raisedBtn;
    private TextInputLayout textInputLayout;
    private TextInputEditText editText;
    private MainFragmentPresenter fragmentPresenter;
    private DialogInterface.OnClickListener dialogOnClickListener;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        interactionListener = (OnFragmentInteractionListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        btnGo = view.findViewById(R.id.button);
        raisedBtn = view.findViewById(R.id.raisedBtn);
        textInputLayout = view.findViewById(R.id.textInput);
        editText = view.findViewById(R.id.editText);

        btnGo.setTextColor(Objects.requireNonNull(getActivity()).getResources().getColor(R.color.colorAccent2));
        GradientDrawable btnShape = (GradientDrawable) btnGo.getBackground();

        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        int myColorPrimary = typedValue.data;
        getContext().getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        int myColorPrimaryDark = typedValue.data;
        getContext().getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        int myColorAccent = typedValue.data;

        btnShape.setColor(myColorPrimary);
        btnShape.setStroke(15, myColorPrimaryDark);
        btnGo.setTextColor(myColorAccent);

        btnGo.setText(getString(R.string.enter_text_click));
        btnGo.setOnClickListener(v -> interactionListener.onButtonGoClick());

        raisedBtn.setOnClickListener(v -> fragmentPresenter.raisedBtnPressed());

        editText.setOnEditorActionListener((v, actionId, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN && catchEmptyTextfield()) {
                showEditTextError();
            }
            if ((actionId == EditorInfo.IME_ACTION_GO || event.getAction() == KeyEvent.ACTION_DOWN) && catchTextViewError()) {
                showTextViewError();
            } else {
                hideTextViewError();
            }
            return false;
        });

        fragmentPresenter = new MainFragmentPresenter();
        fragmentPresenter.attachView(this);
        return view;

    }

    @Override
    public void hideTextViewError() {
        Log.d(TAG, "hideTextViewError()");
        textInputLayout.setError(null);
        btnGo.setText(getString(R.string.click_me));

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            if (btnGo != null) {
                btnGo.setText(getString(R.string.enter_text_click));
            }
        }, 3000);

        YoYo.with(Techniques.Pulse)
                .duration(500)
                .repeat(5)
                .playOn(btnGo);

    }

    @Override
    public void showTextViewError() {
        Log.d(TAG, "showTextViewError()");
        YoYo.with(Techniques.Swing)
                .duration(150)
                .repeat(3)
                .playOn(textInputLayout);
        textInputLayout.setError("Only letters allowed!");
    }

    @Override
    public void showEditTextError() {
        Log.d(TAG, "showEditTextError()");
        YoYo.with(Techniques.Shake)
                .duration(300)
                .repeat(5)
                .playOn(editText);
        editText.setError("Empty string!");
    }


    private boolean catchTextViewError() {
        String textInput = editText.getText().toString();
        return !textInput.matches("[\\D]+");
    }

    private boolean catchEmptyTextfield() {
        return editText.getText().length() == 0;
    }

    @Override
    public void showDialogForm() {
        dialogOnClickListener = new FrameFormListener();
        AlertDialog.Builder ad = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialogTheme);
        ad.setTitle(getString(R.string.introductory_text))
                .setMessage(getString(R.string.introductory_text_content))
                .setPositiveButton(getString(android.R.string.ok), dialogOnClickListener)
                .setNegativeButton(getString(android.R.string.cancel), dialogOnClickListener)
                .create()
                .show();
    }


    public interface OnFragmentInteractionListener {
        void onButtonGoClick();
    }

    private class FrameFormListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            fragmentPresenter.dialogSelected(which);
            dialog.dismiss();
        }
    }


}
