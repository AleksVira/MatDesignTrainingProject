package ru.virarnd.matdesigntrainingproject.start_activity;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import ru.virarnd.matdesigntrainingproject.common.MainContract;

public class StartActivityPresenter implements MainContract.StartPresenter {

    private StartActivity startActivity;

    @Override
    public void attachView(StartActivity startActivity) {
        this.startActivity = startActivity;
    }

    @Override
    public void detachView() {
        startActivity = null;
    }

    @Override
    public void fabClicked(View view) {
        //Do something;
        startActivity.showCustomSnackbar(view);
    }

    @Override
    public void raisedButtonPressed() {

    }

    @Override
    public void onCardClicked() {

    }

    @Override
    public void onDestroy() {

    }
}
