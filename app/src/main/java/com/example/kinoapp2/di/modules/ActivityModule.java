package com.example.kinoapp2.di.modules;

import com.example.kinoapp2.MainActivity;
import com.example.kinoapp2.ui.fragments.FragmentListOfFilms.FragmentListOfFilms;
import com.example.kinoapp2.ui.fragments.FragmentFilm.FragmentFilm;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityModule {
    //генерация AndroidInjector для возвращаемых типов
    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();
    //AppModule будет добавлен к данному сгенерированному сабкомпоненту
    @ContributesAndroidInjector(modules = {AppModule.class})
    abstract FragmentListOfFilms contributesFragmentListOfFilms();

    @ContributesAndroidInjector
    abstract FragmentFilm contributesFragmentFilm();
}
