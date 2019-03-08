package ru.virarnd.matdesigntrainingproject.ui.drawer.fragment_b_sport;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Scene;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import ru.virarnd.matdesigntrainingproject.R;

public class SimpleFragmentB extends Fragment {

    private FrameLayout myContainer;
    private Fragment fragmentSportStart;
    private Fragment fragmentSportEnd;
    private int sceneMarker = 0;


    public SimpleFragmentB() {
        // Required empty public constructor
    }

    public static SimpleFragmentB newInstance() {
        SimpleFragmentB fragmentB = new SimpleFragmentB();
        Bundle args = new Bundle();
        fragmentB.setArguments(args);
        return fragmentB;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        myContainer = view.findViewById(R.id.scene_container);
        Scene scene1 = Scene.getSceneForLayout(myContainer, R.layout.fragment_sport_start, getActivity());
        Scene scene2 = Scene.getSceneForLayout(myContainer, R.layout.fragment_sport_finish, getActivity());
        container.setOnClickListener(ign -> {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(new Fade());
            transitionSet.addTransition(new ChangeBounds());
            transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);
            transitionSet.setDuration(700);
            transitionSet.setInterpolator(new OvershootInterpolator(1.5f));

            if (sceneMarker == 0) {
                sceneMarker = 1;
                TransitionManager.go(scene2, transitionSet);
            } else {
                sceneMarker = 0;
                TransitionManager.go(scene1, transitionSet);
            }
        });
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fragmentSportStart = new FragmentSportStart();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.scene_container, fragmentSportStart).commit();
    }
}
