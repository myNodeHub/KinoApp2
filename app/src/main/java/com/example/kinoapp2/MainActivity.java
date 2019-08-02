package com.example.kinoapp2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.kinoapp2.data.model.Film;
import com.example.kinoapp2.ui.fragments.Fragment1.Fragment1;
import com.example.kinoapp2.ui.fragments.Fragment2.Fragment2;
import com.example.kinoapp2.ui.fragments.FragmentInteractorListener;
import javax.inject.Inject;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector, FragmentInteractorListener {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frr, new Fragment1())
                    .commit();
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void setFilm(Film film) {

        Toast toast = Toast.makeText(getApplicationContext(),
                film.getLocalizedName(), Toast.LENGTH_SHORT);
        toast.show();
        Fragment2 fragment2 = new Fragment2();
        fragment2.setFilm(film);
        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.frr, new Fragment2())
                .commit();
    }
}
