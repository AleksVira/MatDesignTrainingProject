package ru.virarnd.matdesigntrainingproject.ui.drawer.fragment_a;


import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import ru.virarnd.matdesigntrainingproject.R;

public class SimpleFragmentA extends Fragment {

    private ConstraintLayout layout;
    private AnimationDrawable animationDrawable;
    private ImageView imageView;

    public SimpleFragmentA() {
        // Required empty public constructor
    }

    public static SimpleFragmentA newInstance() {
        SimpleFragmentA fragmentA = new SimpleFragmentA();
        Bundle args = new Bundle();
        fragmentA.setArguments(args);
        return fragmentA;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        layout = view.findViewById(R.id.frame_layout_fragment_a);
        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.setExitFadeDuration(2000);

        imageView = view.findViewById(R.id.plane_image);
        animateImage();

        return view;
    }

    private void animateImage() {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimatedVectorDrawable) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (drawable instanceof AnimatedVectorDrawableCompat) {
            ((AnimatedVectorDrawableCompat) drawable).start();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Запуск анимации
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            animationDrawable.start();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        // Останов анимации
        if (animationDrawable != null && animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
    }

}
