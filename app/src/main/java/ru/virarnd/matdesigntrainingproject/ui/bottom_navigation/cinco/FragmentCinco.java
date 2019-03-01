package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.cinco;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import ru.virarnd.matdesigntrainingproject.R;

public class FragmentCinco extends Fragment {

    private View view;
    public FragmentCinco() {
    }

    public static FragmentCinco newInstance() {
        return new FragmentCinco();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_bottom_navigation_cinco, container, false);
        }
        return view;
    }

}
