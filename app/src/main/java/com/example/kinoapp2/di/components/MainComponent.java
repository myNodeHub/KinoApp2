package com.example.kinoapp2.di.components;

import android.app.Application;

import com.example.kinoapp2.App;
import com.example.kinoapp2.di.modules.ActivityModule;
import com.example.kinoapp2.di.modules.RecyclerViewAdapterModule;
import com.example.kinoapp2.di.modules.RetrofitModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityModule.class, RecyclerViewAdapterModule.class, RetrofitModule.class})
public interface MainComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        MainComponent build();
    }
    //зависимости предназначенны для объекта App
    void inject(App app);

}
