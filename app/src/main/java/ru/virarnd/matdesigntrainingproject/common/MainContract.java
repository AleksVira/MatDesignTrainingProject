package ru.virarnd.matdesigntrainingproject.common;

import android.view.View;

import java.util.ArrayList;

import ru.virarnd.matdesigntrainingproject.model.Spot;
import ru.virarnd.matdesigntrainingproject.start_activity.StartActivity;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos.FragmentAllPhotos;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos.FragmentAllPhotosPresenter;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos.FragmentDos;
import ru.virarnd.matdesigntrainingproject.model.PhotoItem;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.uno.FragmentUno;
import ru.virarnd.matdesigntrainingproject.ui.main.MainFragment;

public interface MainContract {

    interface StartView {
        void showCards();

    }

    interface StartPresenter {
        void attachView(StartActivity startActivity);
        void detachView();
        void fabClicked(View view);
        void raisedButtonPressed();
        void navigationItemWasSelected(int id);
        void onCardClicked();
        void onDestroy();

        void nameOfVisibleFragment(String fragmentName);
    }


    interface MainFragmentView {
        void showTextViewError();
        void hideTextViewError();
        void showEditTextError();
        void showDialogForm();
    }

    interface MainFragmentPresenterRules {
        void attachView(MainFragment mainFragment);
        void detachView();
        void raisedBtnPressed();
        void dialogSelected(int which);
    }

    interface FragmentCardsView {

    }

    interface FragmentCardsPresenterRules {
    }

    interface DataModel {
        String loadPictures();
        ArrayList<Spot> loadSpotList();
        ArrayList<PhotoItem> loadAllPhotosList();
    }

    interface FragmentUnoView {

    }

    interface FragmentUnoPresenterRules {
        void attachView(FragmentUno fragmentUno);
        void detachView();

        ArrayList<Spot> getSpotList();
    }

    interface FragmentDosPresenterRules {
        void attachView(FragmentDos fragmentUno);
        void detachView();
    }

    interface FragmentAllPhotosPresenterRules {
        void attachView(FragmentAllPhotos fragmentAllPhotos);
        void detachView();

        ArrayList<PhotoItem> getPhotoItemsList();
    }
}
