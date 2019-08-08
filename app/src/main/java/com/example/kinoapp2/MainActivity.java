package com.example.kinoapp2;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.kinoapp2.ui.fragments.FragmentListOfFilms.FragmentListOfFilms;
import com.example.kinoapp2.ui.fragments.FragmentFilm.FragmentFilm;
import javax.inject.Inject;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import com.example.kinoapp2.ui.fragments.FragmentInteractorListener;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector, FragmentInteractorListener {
    private static final String BACK_STACK_ROOT_TAG = "root_fragment";
    //Проверка подключения к интернету
    public static boolean isOnline(Context context)
    {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting())
        {
            return true;
        }
        return false;
    }
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if ( !isOnline(getApplicationContext()) ){
            Toast.makeText(this, "Проверьте подключение к интернету", Toast.LENGTH_LONG).show();
        }
        //разрешение инжекций
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //установка фрагмента в активити
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frr, new FragmentListOfFilms())
                    .commit();
    }
    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
    //вызываю по клику в RecyclerViewAdapterFilm, передаю bundle в созданый фрагмент, заменяю FragmentListOfFilms на FragmentFilm
    @Override
    public void setBundle(Bundle bundle) {
        FragmentFilm fragment2 = new FragmentFilm();
        fragment2.setFilmBundle(bundle);
        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(BACK_STACK_ROOT_TAG)
                .replace(R.id.frr, new FragmentFilm())
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
