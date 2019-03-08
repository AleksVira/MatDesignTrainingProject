package ru.virarnd.matdesigntrainingproject.start_activity;

import android.view.View;

import ru.virarnd.matdesigntrainingproject.R;
import ru.virarnd.matdesigntrainingproject.common.MainContract;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos.FragmentDos;

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
        startActivity.showCustomSnackBar(view);
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

    @Override
    public void nameOfVisibleFragment(String fragmentName) {
        if (fragmentName.equals(FragmentDos.class.getSimpleName())) {
            startActivity.hideDownBottomNavigationBar();
        }
    }

    @Override
    public void navigationItemWasSelected(int id) {
        if (id == R.id.fragment_a) {
            startActivity.showFragmentA();
        } else if (id == R.id.fragment_b) {
            startActivity.showFragmentB();
        } else if (id == R.id.fragment_c) {
            startActivity.showFragmentC();
        }

    }

}
