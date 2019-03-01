package ru.virarnd.matdesigntrainingproject.start_activity;

import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import ru.virarnd.matdesigntrainingproject.R;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.cinco.FragmentCinco;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.cuatro.FragmentCuatro;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos.FragmentDos;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.tres.FragmentTres;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.uno.FragmentUno;

public class MyBottomNavigationViewListener implements BottomNavigationView.OnNavigationItemSelectedListener {
    private final static String TAG = MyBottomNavigationViewListener.class.getSimpleName();
    private StartActivity startActivity;
    private BottomNavigationView bottomNavigationView;

    public MyBottomNavigationViewListener(StartActivity startActivity, BottomNavigationView bottomNavigationView) {
        this.startActivity = startActivity;
        this.bottomNavigationView = bottomNavigationView;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Log.d(TAG, "onNavigationItemSelected: " + menuItem.getItemId());
        bottomNavigationView.getMenu().setGroupCheckable(0, true, true);
        switch (menuItem.getItemId()) {
            case (R.id.bot_nav_action_1):
                replaceFragment(FragmentUno.newInstance(), FragmentUno.class.getSimpleName());
                break;
            case (R.id.bot_nav_action_2):
                replaceFragment(FragmentDos.newInstance(), FragmentDos.class.getSimpleName());
                break;
            case (R.id.bot_nav_action_3):
                replaceFragment(FragmentTres.newInstance(), FragmentTres.class.getSimpleName());
                break;
            case (R.id.bot_nav_action_4):
                replaceFragment(FragmentCuatro.newInstance(), FragmentCuatro.class.getSimpleName());
                break;
            case (R.id.bot_nav_action_5):
                replaceFragment(FragmentCinco.newInstance(), FragmentCinco.class.getSimpleName());
                break;
            default:
                Log.e(TAG, "Ошибка в BottomNavigationView!");
        }
        return true;

    }

    private void replaceFragment(Fragment fragment, String fragmentTag) {
        // Сначала проверка на то, что такой же фрагмент уже загружен и показывается
        Fragment currentFragment = startActivity.getSupportFragmentManager().findFragmentByTag(fragmentTag);
        // Если такого фрагмента нету на экране, добавляю
        if (currentFragment == null) {
            startActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, fragment, fragmentTag)
                    .addToBackStack(fragmentTag)
                    .commit();
            return;
        }
        // Если он есть и сейчас показан
        if (currentFragment.isVisible()) {
            Log.e(TAG, "Fragment now on the screen!");
            // В остальных случчаях заменяю фрагмент на нужный
        } else {
            startActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, currentFragment, fragmentTag)
                    .addToBackStack(fragmentTag)
                    .commit();
        }
    }
}
