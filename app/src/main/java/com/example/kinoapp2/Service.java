package com.example.kinoapp2;

import com.example.kinoapp2.data.model.Films;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Service {



    @GET("films.json")
    Call<Films> getFilms();

//    @GET("")
//    Call<Film> getFilm(@Url String newslink);
}
