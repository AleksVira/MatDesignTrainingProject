package ru.virarnd.matdesigntrainingproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import ru.virarnd.matdesigntrainingproject.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {

    public static final String THEME = "Theme";
    private MainFragment mainFragment;
    private Toolbar toolbar;
    private int themeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            themeNumber = 1;
        } else {
            themeNumber = savedInstanceState.getInt(THEME);
        }
        System.out.println("Проверка !!!");
        if (themeNumber != 0) {
            System.out.println("Проверка темы! " + themeNumber);
            switch (themeNumber) {
                case 1:
                    getTheme().applyStyle(R.style.AppTheme_First, true);
                    break;
                case 2:
                    getTheme().applyStyle(R.style.AppTheme_Second, true);
                    break;
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainFragment = MainFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, mainFragment).commitNow();


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(THEME, themeNumber);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onButtonGoClick() {
        Intent intent = new Intent(this, ColorThemeActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data == null) {
            return;
        }
        themeNumber = data.getIntExtra("theme_number", 1);
        System.out.println("ТЕМА: " + themeNumber);

        switch (themeNumber) {
            case 1:
                getTheme().applyStyle(R.style.AppTheme_First, true);
                break;
            case 2:
                getTheme().applyStyle(R.style.AppTheme_Second, true);
                break;
        }
        recreate();
    }
}
