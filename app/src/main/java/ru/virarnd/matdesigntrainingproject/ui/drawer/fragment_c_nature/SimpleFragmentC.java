package ru.virarnd.matdesigntrainingproject.ui.drawer.fragment_c_nature;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import ru.virarnd.matdesigntrainingproject.R;

public class SimpleFragmentC extends Fragment {

    private Fragment fragmentNatureStart = FragmentNatureStart.newInstance();


    public SimpleFragmentC() {
        // Required empty public constructor
    }

    public static SimpleFragmentC newInstance() {
        SimpleFragmentC fragmentC = new SimpleFragmentC();
        Bundle args = new Bundle();
        fragmentC.setArguments(args);
        return fragmentC;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.nature_container, fragmentNatureStart).commit();

    }
}
