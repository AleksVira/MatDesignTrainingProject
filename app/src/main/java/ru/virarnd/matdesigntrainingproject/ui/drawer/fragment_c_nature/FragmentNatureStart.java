package ru.virarnd.matdesigntrainingproject.ui.drawer.fragment_c_nature;


import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import ru.virarnd.matdesigntrainingproject.R;

public class FragmentNatureStart extends Fragment {

    private ImageView ivMountain;
    private Fragment fragmentNatureEnd = FragmentNatureEnd.newInstance();
    private View view;

    public FragmentNatureStart() {
        // Required empty public constructor
    }

    public static FragmentNatureStart newInstance() {
        FragmentNatureStart fragmentNatureStart = new FragmentNatureStart();
        Bundle args = new Bundle();
        fragmentNatureStart.setArguments(args);
        return fragmentNatureStart;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nature_start, container, false);
        ivMountain = view.findViewById(R.id.ivMountain);
        ivMountain.setOnClickListener(ign -> {
            makeTransition();
        });
        return view;
    }


    private void makeTransition() {
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.RIGHT);
        slide.setDuration(1000);
        TransitionSet set = new TransitionSet();
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(1000);
        changeBounds.setInterpolator(new OvershootInterpolator(1.5f));
        set.addTransition(slide);
        set.addTransition(changeBounds);
        set.setOrdering(TransitionSet.ORDERING_TOGETHER);
        fragmentNatureEnd.setSharedElementEnterTransition(set);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.nature_container, fragmentNatureEnd)
                .addToBackStack(FragmentNatureStart.class.getName())
                .addSharedElement(ivMountain, "mountain")
                .commit();
    }
}
