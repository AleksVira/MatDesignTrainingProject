package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.uno;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import ru.virarnd.matdesigntrainingproject.R;
import ru.virarnd.matdesigntrainingproject.common.MainContract;

public class FragmentUno extends Fragment implements MainContract.FragmentUnoView {

    private static final String TAG = FragmentUno.class.getName();

    private View view;
    private RecyclerView recyclerView;
    private FragmentUnoPresenter fragmentPresenter;
    private SnapHelper snapHelper;
    private Activity parentActivity;

    private OnScrollListener scrollListener;

    public FragmentUno() {
    }

    public static FragmentUno newInstance() {
        FragmentUno fragment = new FragmentUno();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        scrollListener = (OnScrollListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentPresenter = new FragmentUnoPresenter();
        fragmentPresenter.attachView(this);
        parentActivity = getActivity();
        Log.d(TAG, parentActivity.getClass().getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_bottom_navigation_uno, container, false);
        }
        recyclerView = view.findViewById(R.id.rv_cards_grid);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new SpotAdapter(fragmentPresenter));
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollListener.onScrollY(dy);
            }
        });

/*
        if (snapHelper == null) {
            snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(recyclerView);
        }
*/

        return view;
    }

    public interface OnScrollListener {
        void onScrollY(int yScroll);
        void onPauseFragmentUno();

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "I’m not visible!!!");
        scrollListener.onPauseFragmentUno();
    }
}
