package ru.virarnd.matdesigntrainingproject.ui.drawer.fragment_b_sport;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import ru.virarnd.matdesigntrainingproject.R;

public class FragmentSportStart extends Fragment {

    ImageView imageRunners;
    ImageView imageRunner;
    ImageView imageFinish;

    public FragmentSportStart() {
        // Required empty public constructor
    }

    public static FragmentSportStart newInstance() {
        FragmentSportStart fragmentSportStart = new FragmentSportStart();
        Bundle args = new Bundle();
        fragmentSportStart.setArguments(args);
        return fragmentSportStart;
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
