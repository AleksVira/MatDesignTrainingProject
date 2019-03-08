package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos;

import java.util.ArrayList;

import ru.virarnd.matdesigntrainingproject.common.MainContract;
import ru.virarnd.matdesigntrainingproject.model.Model;
import ru.virarnd.matdesigntrainingproject.model.PhotoItem;

public class FragmentAllPhotosPresenter implements MainContract.FragmentAllPhotosPresenterRules {

    private FragmentAllPhotos fragmentAllPhotos;
    private Model model;


    @Override
    public void attachView(FragmentAllPhotos fragmentAllPhotos) {
        this.fragmentAllPhotos = fragmentAllPhotos;
        model = new Model();
    }

    @Override
    public void detachView() {
        fragmentAllPhotos = null;
    }

    @Override
    public ArrayList<PhotoItem> getPhotoItemsList() {
        return model.loadAllPhotosList();
    }
}
