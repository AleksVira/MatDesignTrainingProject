package ru.virarnd.matdesigntrainingproject.common;

import android.view.View;

import ru.virarnd.matdesigntrainingproject.base_activity.BaseActivity;
import ru.virarnd.matdesigntrainingproject.start_activity.StartActivity;
import ru.virarnd.matdesigntrainingproject.ui.main.MainFragment;

public interface MainContract {

    interface BaseView {
        void drawerItemSelected();
        void toolbarItemSelected();
        void fabClicked();
    }

    interface BasePresenter {
        void attachView(BaseActivity baseActivity);
        void detachView();
    }


    interface StartView {
        void showCards();

    }

    interface StartPresenter {
        void attachView(StartActivity startActivity);
        void detachView();
        void fabClicked(View view);
        void raisedButtonPressed();

        void onCardClicked();

        void onDestroy();

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


    interface DataModel {
        String loadPictures();
    }
}
