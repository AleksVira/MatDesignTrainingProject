package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.cuatro;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import ru.virarnd.matdesigntrainingproject.R;

public class FragmentCuatro extends Fragment {

    private View view;
    public FragmentCuatro() {
    }

    public static FragmentCuatro newInstance() {
        return new FragmentCuatro();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_bottom_navigation_cuatro, container, false);
        }
        return view;
    }

}
