package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import ru.virarnd.matdesigntrainingproject.R;

public class FragmentSelectedPhotos extends Fragment {

    private static final String TEXT = "TEXT";
    private View view;

    public FragmentSelectedPhotos() {
    }

    public static FragmentSelectedPhotos newInstance() {
        FragmentSelectedPhotos fragmentAllPhotos = new FragmentSelectedPhotos();
        Bundle args = new Bundle();
        args.putString(TEXT, "selected");
        fragmentAllPhotos.setArguments(args);
        return fragmentAllPhotos;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_bn_dos_selected_photos, container, false);
        }

        return view;
    }

}
