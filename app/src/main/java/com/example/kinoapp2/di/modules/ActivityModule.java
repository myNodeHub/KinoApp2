package com.example.kinoapp2.di.modules;

import com.example.kinoapp2.MainActivity;
import com.example.kinoapp2.ui.fragments.Fragment1.Fragment1;
import com.example.kinoapp2.ui.fragments.Fragment2.Fragment2;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();

    @ContributesAndroidInjector(modules = {AppModule.class})
    abstract Fragment1 contributesFragment1();

    @ContributesAndroidInjector
    abstract Fragment2 contributesFragment2();
}
