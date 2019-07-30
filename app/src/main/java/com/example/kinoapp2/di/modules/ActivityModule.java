package com.example.kinoapp2.di.modules;

import com.example.kinoapp2.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();

//    @ContributesAndroidInjector
//    abstract NewsActivity contributesNewsActivity();
}
