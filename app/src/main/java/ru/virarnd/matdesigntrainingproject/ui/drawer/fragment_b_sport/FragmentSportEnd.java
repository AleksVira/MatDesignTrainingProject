package ru.virarnd.matdesigntrainingproject.ui.drawer.fragment_b_sport;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import ru.virarnd.matdesigntrainingproject.R;

public class FragmentSportEnd extends Fragment {

    ImageView imageRunners;
    ImageView imageRunner;
    ImageView imageFinish;

    public FragmentSportEnd() {
        // Required empty public constructor
    }

    public static FragmentSportEnd newInstance() {
        FragmentSportEnd fragmentSportEnd = new FragmentSportEnd();
        Bundle args = new Bundle();
        fragmentSportEnd.setArguments(args);
        return fragmentSportEnd;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sport_start, container, false);

        imageRunners = view.findViewById(R.id.runners);
        imageRunner = view.findViewById(R.id.runner_fast);
        imageFinish = view.findViewById(R.id.finish);

        return view;
    }

}
