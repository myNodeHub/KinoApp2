package com.example.kinoapp2.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.kinoapp2.Service.BASE_URL;


@Module
public class RetrofitModule {

//    @Singleton
//    @Provides
//    public Retrofit getRetrofit(){
//        return Retrofit;
//    }

    @Singleton
    @Provides
    public OkHttpClient getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return client;
    }

    @Singleton
    @Provides
    public Gson getGson() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return gson;
    }


    @Singleton
    @Provides
    public Retrofit getRetrofit(OkHttpClient client, Gson gson) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }
}
