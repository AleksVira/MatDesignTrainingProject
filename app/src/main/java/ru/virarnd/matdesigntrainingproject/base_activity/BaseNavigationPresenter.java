package ru.virarnd.matdesigntrainingproject.base_activity;

import ru.virarnd.matdesigntrainingproject.common.MainContract;

public class BaseNavigationPresenter implements MainContract.BasePresenter {

    private BaseActivity view;

    @Override
    public void attachView(BaseActivity baseActivity) {
        this.view = baseActivity;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
