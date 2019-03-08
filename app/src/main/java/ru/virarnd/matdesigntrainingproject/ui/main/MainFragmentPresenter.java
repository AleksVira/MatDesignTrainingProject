package ru.virarnd.matdesigntrainingproject.ui.main;

import android.util.Log;

import ru.virarnd.matdesigntrainingproject.common.MainContract;

class MainFragmentPresenter implements MainContract.MainFragmentPresenterRules{

    private final static String TAG = MainFragmentPresenter.class.getSimpleName();
    private MainFragment mainFragment;

    @Override
    public void attachView(MainFragment mainFragment) {
        this.mainFragment = mainFragment;
    }

    @Override
    public void detachView() {
        mainFragment = null;
    }


    @Override
    public void raisedBtnPressed() {
        Log.d(TAG, "Wow! Raised button was pressed! I mast show dialog menu");
        mainFragment.showDialogForm();
    }

    @Override
    public void dialogSelected(int which) {
        Log.d(TAG, "Was selected: " + which);
        switch (which) {
            case -1:
                Log.d(TAG, "YES");
                break;
            case -2:
                Log.d(TAG, "CHANCEL");
                break;
            default:
                Log.d(TAG, "Unknown");
        }
    }
}
