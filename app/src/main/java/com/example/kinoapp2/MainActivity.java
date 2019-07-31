package com.example.kinoapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kinoapp2.data.model.Film;
import com.example.kinoapp2.data.model.Films;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Inject
    Service service;

    Films films = new Films();

    RecyclerView recViwFilm, recViwGenre;
    public RecyclerViewAdapterGenre recyclerViewAdapterGenre;
    public RecyclerViewAdapterFilm recyclerViewAdapterFilm;
    //    ArrayList<Genre> genreList = new ArrayList<>();
    List<Film> filmList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recViwGenre = findViewById(R.id.recViwGenre);
        recViwFilm = findViewById(R.id.recViwFilm);


        recyclerViewAdapterFilm = new RecyclerViewAdapterFilm(getApplicationContext());
        recViwFilm.setLayoutManager(new GridLayoutManager(this, 2));
        recViwFilm.setAdapter(recyclerViewAdapterFilm); //присвоение рец.вью адаптера

        recyclerViewAdapterGenre = new RecyclerViewAdapterGenre(getApplicationContext(), recyclerViewAdapterFilm);
        recViwGenre.setLayoutManager(new LinearLayoutManager(getApplicationContext())); //присвоение рец.вью лайоутМэнеджера
        recViwGenre.setAdapter(recyclerViewAdapterGenre); //присвоение рец.вью адаптера

        service.getFilms().enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                films = response.body();
                filmList = films.getFilms();
                recyclerViewAdapterFilm.setData(filmList);
                recyclerViewAdapterGenre.setData(filmList);
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {

            }
        });
    }


}
