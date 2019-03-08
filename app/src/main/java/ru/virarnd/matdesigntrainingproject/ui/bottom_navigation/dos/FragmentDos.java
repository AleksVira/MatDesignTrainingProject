package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos;


import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ru.virarnd.matdesigntrainingproject.R;

public class FragmentDos extends Fragment {

    private static final String TAG = FragmentDos .class.getName();

    @BindView(R.id.vp_fragment_dos)
    ViewPager viewPager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.front_view)
    View frontView;

    @BindView(R.id.background_view)
    View backgroundView;

    private Unbinder unbinder;
    private View view;



    public FragmentDos() {
    }


/*
    public static FragmentDos newInstance(String text) {
        FragmentDos fragment = new FragmentDos();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }
*/


    public static FragmentDos newInstance() {
        return new FragmentDos();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        fragmentPresenter = new FragmentDosPresenter();
//        fragmentPresenter.attachView(this);

/*
        if (getArguments() != null) {
            text = getArguments().getString(TEXT);
        }
*/


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_bottom_navigation_dos, container, false);
        }
        unbinder = ButterKnife.bind(this, view);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(FragmentAllPhotos.newInstance(), "All photos");
        adapter.addFragment(FragmentSelectedPhotos.newInstance(), "Selected photos");
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new PageTransformation());
        tabLayout.setupWithViewPager(viewPager);
        setChangingTabColorOnScroll();
        return view;
    }


    private void setChangingTabColorOnScroll() {
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayout.setBackgroundColor(getBackgroundColor(position, positionOffset));
            }
        });

    }
    private int getBackgroundColor(int position, float positionOffset) {
        int startColor = ResourcesCompat.getColor(getResources(), position == 0
                ? R.color.colorPrimary
                : R.color.colorPrimaryDark, getActivity().getTheme());
        int endColor = ResourcesCompat.getColor(getResources(), position == 0
                ? R.color.colorPrimaryDark
                : R.color.colorPrimary, getActivity().getTheme());
        return (int) new ArgbEvaluator().evaluate(positionOffset, startColor, endColor);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
