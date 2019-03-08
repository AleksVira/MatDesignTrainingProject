package ru.virarnd.matdesigntrainingproject.ui.drawer.fragment_c_nature;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import ru.virarnd.matdesigntrainingproject.R;

public class FragmentNatureEnd extends Fragment {

    public FragmentNatureEnd() {
        // Required empty public constructor
    }

    public static FragmentNatureEnd newInstance() {
        FragmentNatureEnd fragmentSportEnd = new FragmentNatureEnd();
        Bundle args = new Bundle();
        fragmentSportEnd.setArguments(args);
        return fragmentSportEnd;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nature_finish, container, false);
        return view;
    }

}
