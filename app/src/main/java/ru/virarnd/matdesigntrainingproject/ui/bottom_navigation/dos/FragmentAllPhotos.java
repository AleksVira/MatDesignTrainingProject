package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.virarnd.matdesigntrainingproject.R;

public class FragmentAllPhotos extends Fragment {

    private static final String TAG = FragmentAllPhotos.class.getSimpleName();

//    private static final String TEXT = "TEXT";
    private View view;
    private RecyclerView recyclerView;
    private FragmentAllPhotosPresenter presenter;
    private AllPhotosAdapter adapter;


    public FragmentAllPhotos() {
    }

    public static FragmentAllPhotos newInstance() {
        FragmentAllPhotos fragmentAllPhotos = new FragmentAllPhotos();
        Bundle args = new Bundle();
//        args.putString(TEXT, "All photos");
//        fragmentAllPhotos.setArguments(args);
        return fragmentAllPhotos;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new FragmentAllPhotosPresenter();
        presenter.attachView(this);
        adapter = new AllPhotosAdapter(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_bn_dos_all_photos, container, false);
        }
        recyclerView = view.findViewById(R.id.rv_all_photos);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "onCreateView()");
        return view;
    }

}
