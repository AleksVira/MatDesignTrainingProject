package ru.virarnd.matdesigntrainingproject.start_activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import ru.virarnd.matdesigntrainingproject.R;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos.FragmentDos;
import ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.uno.FragmentUno;
import ru.virarnd.matdesigntrainingproject.ui.drawer.fragment_a.SimpleFragmentA;
import ru.virarnd.matdesigntrainingproject.ui.drawer.fragment_b_sport.SimpleFragmentB;
import ru.virarnd.matdesigntrainingproject.ui.drawer.fragment_c_nature.SimpleFragmentC;
import ru.virarnd.matdesigntrainingproject.ui.main.MainFragment;


public class StartActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener, FragmentUno.OnScrollListener {
    private final static String TAG = StartActivity.class.getSimpleName();

    private MainFragment mainFragment;
    private SimpleFragmentA fragmentA;
    private SimpleFragmentB fragmentB;
    private SimpleFragmentC fragmentC;
    private BottomNavigationView bottomNavigationView;
    private StartActivityPresenter presenter;
    private FloatingActionButton fab;
    private NavigationView navigationView;

    private float recyclerViewScrollY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        presenter = new StartActivityPresenter();
        presenter.attachView(this);

        mainFragment = MainFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, mainFragment, MainFragment.class.getName()).addToBackStack(MainFragment.class.getName()).commit();

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> presenter.fabClicked(view));

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.getMenu().setGroupCheckable(0, false, true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new MyBottomNavigationViewListener(this, presenter, bottomNavigationView));


    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        presenter.navigationItemWasSelected(id);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onButtonGoClick() {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            bottomNavigationView.getMenu().setGroupCheckable(0, false, true);
            FragmentManager fm = getSupportFragmentManager();
            Log.d(TAG, "popBackStack()");
            int lastFragmentCount = fm.getBackStackEntryCount() - 1;
            FragmentManager.BackStackEntry lastFragmentInStack = fm.getBackStackEntryAt(lastFragmentCount);
            String backStackEntryName = lastFragmentInStack.getName();
            Log.d(TAG, "Last in BackStack name = " + backStackEntryName);
            if (backStackEntryName.equals(FragmentDos.class.getSimpleName())) {
                //TODO Show BNV again
                Log.d(TAG, "Now I’ll show you BottomNavView again");
                showAgainBottomNavigationBar();
            }
            if (fm.getBackStackEntryCount() == 1) {
                finish();
            } else {
                fm.popBackStack();
            }
        }
    }

    @Override
    protected void onStop() {
        presenter.detachView();
        super.onStop();
    }


    public void showFragmentA() {
        fragmentA = SimpleFragmentA.newInstance();
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frame_layout, fragmentA).
                addToBackStack(SimpleFragmentA.class.getName()).
                commit();
    }

    public void showFragmentB() {
        fragmentB = SimpleFragmentB.newInstance();
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frame_layout, fragmentB).
                addToBackStack(SimpleFragmentB.class.getName()).
                commit();
    }

    public void showFragmentC() {
        fragmentC = SimpleFragmentC.newInstance();
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frame_layout, fragmentC).
                addToBackStack(SimpleFragmentC.class.getName()).
                commit();
    }

    public void showCustomSnackBar(View view) {
        Snackbar snackbar = Snackbar.make(view, "Фото добавлено", Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(getResources().getColor(R.color.design_default_color_primary));
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        int colorPrimary = typedValue.data;
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(colorPrimary);
        snackbar.setAction("Action", null);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) snackbar.getView().getLayoutParams();
        // SnackBar учитывает текущее положение BNV
        params.setMargins(0, 0, 0, (int)(bottomNavigationView.getHeight() - bottomNavigationView.getTranslationY()));
        snackbar.getView().setLayoutParams(params);

        snackbar.show();
    }

    @Override
    public void onScrollY(int yScroll) {
        // Когда скролл вверх, BNV прячется. Когда хоть немного вниз -- появляется.
        recyclerViewScrollY += yScroll;
        if (yScroll >= 0) {
            bottomNavigationView.setTranslationY(recyclerViewScrollY / 2.5f);
        } else {
            bottomNavigationView.setTranslationY(0);
        }
    }

    @Override
    public void onPauseFragmentUno() {
        bottomNavigationView.setTranslationY(0);
    }

    public void hideDownBottomNavigationBar() {
        ObjectAnimator bottomNavigationViewAnimatorX = ObjectAnimator.ofFloat(bottomNavigationView, "translationX", bottomNavigationView.getWidth());
        ObjectAnimator bottomNavigationViewAnimatorY = ObjectAnimator.ofFloat(bottomNavigationView, "translationY", bottomNavigationView.getWidth());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(bottomNavigationViewAnimatorX, bottomNavigationViewAnimatorY);
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.start();
    }

    public void showAgainBottomNavigationBar() {
        ObjectAnimator bottomNavigationViewAnimatorX = ObjectAnimator.ofFloat(bottomNavigationView, "translationX", 0);
        ObjectAnimator bottomNavigationViewAnimatorY = ObjectAnimator.ofFloat(bottomNavigationView, "translationY", 0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(bottomNavigationViewAnimatorX, bottomNavigationViewAnimatorY);
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.start();
    }
}
