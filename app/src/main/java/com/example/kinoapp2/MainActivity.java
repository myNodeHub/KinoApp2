package com.example.kinoapp2;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.example.kinoapp2.data.model.Film;
import com.example.kinoapp2.ui.fragments.Fragment1.Fragment1;
import com.example.kinoapp2.ui.fragments.Fragment2.Fragment2;
import javax.inject.Inject;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import com.example.kinoapp2.ui.fragments.FragmentInteractorListener;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector, FragmentInteractorListener {

    private static final String BACK_STACK_ROOT_TAG = "root_fragment";

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
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack(BACK_STACK_ROOT_TAG)
                    .add(R.id.frr, new Fragment1())
                    .commit();
    }
    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
    @Override
    public void setBundle(Bundle bundle) {
        Fragment2 fragment2 = new Fragment2();
        fragment2.setFilmBundle(bundle);
        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .replace(R.id.frr, new Fragment2())
                .commit();
    }
}
