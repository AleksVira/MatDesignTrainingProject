package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.virarnd.matdesigntrainingproject.R;

public class FragmentDos extends Fragment {

    private View view;
    public FragmentDos() {
    }

    public static FragmentDos newInstance() {
        return new FragmentDos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_bottom_navigation_dos, container, false);
        }
        return view;
    }

}
