package com.example.kinoapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kinoapp2.data.model.Film;
import com.example.kinoapp2.data.model.Genre;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recViwGenre, recViwFilm;
    public RecyclerViewAdapterGenre recyclerViewAdapterGenre;
    public RecyclerViewAdapterFilm recyclerViewAdapterFilm;
    ArrayList<Genre> genreList = new ArrayList<>();
    ArrayList<Film> filmList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recViwGenre = findViewById(R.id.recViwGenre);
        genreList.add(new Genre("Fantasy"));
        genreList.add(new Genre("Comedy"));
        genreList.add(new Genre("Thriller"));

        recViwFilm = findViewById(R.id.recViwFilm);
        filmList.add(new Film("Fantasy", "The-Fantasy-Film"));
        filmList.add(new Film("Fantasy", "22The-Fantasy-Film"));
        filmList.add(new Film("Comedy", "The-Comedy-Film"));
        filmList.add(new Film("Thriller", "The-Thriller-Film"));



        recyclerViewAdapterFilm = new RecyclerViewAdapterFilm(getApplicationContext());
//        recViwFilm.setLayoutManager(new LinearLayoutManager(getApplicationContext())); //присвоение рец.вью лайоутМэнеджера
        recViwFilm.setLayoutManager(new GridLayoutManager(this, 2));
        recViwFilm.setAdapter(recyclerViewAdapterFilm); //присвоение рец.вью адаптера
//        recyclerViewAdapterFilm.setData(filmList);


        recyclerViewAdapterGenre = new RecyclerViewAdapterGenre(getApplicationContext(), recyclerViewAdapterFilm);
        recViwGenre.setLayoutManager(new LinearLayoutManager(getApplicationContext())); //присвоение рец.вью лайоутМэнеджера
        recViwGenre.setAdapter(recyclerViewAdapterGenre); //присвоение рец.вью адаптера
        recyclerViewAdapterGenre.setData(genreList);
        recyclerViewAdapterGenre.setDataFilm(filmList);
    }



}
