package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.tres;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import ru.virarnd.matdesigntrainingproject.R;

public class FragmentTres extends Fragment {

    private View view;
    public FragmentTres() {
    }

    public static FragmentTres newInstance() {
        return new FragmentTres();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_bottom_navigation_tres, container, false);
        }
        return view;
    }

}
