package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.uno;

import java.util.ArrayList;

import ru.virarnd.matdesigntrainingproject.common.MainContract;
import ru.virarnd.matdesigntrainingproject.model.Model;
import ru.virarnd.matdesigntrainingproject.model.Spot;

public class FragmentUnoPresenter implements MainContract.FragmentUnoPresenterRules {

    private FragmentUno fragmentUno;
    private Model model;

    @Override
    public void attachView(FragmentUno fragmentUno) {
        this.fragmentUno = fragmentUno;
        model = new Model();
    }

    @Override
    public void detachView() {
        fragmentUno = null;
    }

    @Override
    public ArrayList<Spot> getSpotList() {
        return model.loadSpotList();
    }
}
