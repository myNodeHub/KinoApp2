package com.example.kinoapp2.di.modules;

import android.app.Application;
import android.content.Context;
import com.example.kinoapp2.di.qalifire.ApplicationContext;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @ApplicationContext
    @Provides
    Context getContext1(Application application){
        return application;
    }
}