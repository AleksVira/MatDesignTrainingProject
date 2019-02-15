package ru.virarnd.matdesigntrainingproject.start_activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import ru.virarnd.matdesigntrainingproject.ColorThemeActivity;
import ru.virarnd.matdesigntrainingproject.R;
import ru.virarnd.matdesigntrainingproject.base_activity.BaseActivity;
import ru.virarnd.matdesigntrainingproject.ui.main.MainFragment;

public class StartActivity extends BaseActivity implements MainFragment.OnFragmentInteractionListener {

    private final static String TAG = StartActivity.class.getSimpleName();
    private static final String THEME = "Theme";

    private MainFragment main_fragment;
    private Toolbar toolbar;
    private int themeNumber;
    private StartActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            themeNumber = 2;
        } else {
            themeNumber = savedInstanceState.getInt(THEME);
        }
        System.out.println("Проверка !!!");
        if (themeNumber != 0) {
                switch (themeNumber) {
                case 1:
                    setNewTheme(R.style.AppTheme_First);
                    break;
                case 2:
                    setNewTheme(R.style.AppTheme_Second);
                    break;
            }
        }
        super.onCreate(savedInstanceState);

        presenter = new StartActivityPresenter();
        presenter.attachView(this);


        main_fragment = MainFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, main_fragment).commitNow();

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.fabClicked(view);

            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(THEME, themeNumber);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onButtonGoClick() {
        Intent intent = new Intent(this, ColorThemeActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "onActivityResult");
        if (data == null) {
            return;
        }
        themeNumber = data.getIntExtra("theme_number", 1);
        System.out.println("ТЕМА: " + themeNumber);

        switch (themeNumber) {
            case 1:
                setNewTheme(R.style.AppTheme_First);
                break;
            case 2:
                setNewTheme(R.style.AppTheme_Second);
                break;
        }
        recreate();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    public void showCustomSnackbar(View view) {
        Snackbar snackbar = Snackbar.make(view, "Фото добавлено", Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(getResources().getColor(R.color.design_default_color_primary));
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        int colorPrimary = typedValue.data;
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(colorPrimary);
        snackbar.setAction("Action", null);
        snackbar.show();
    }
}
