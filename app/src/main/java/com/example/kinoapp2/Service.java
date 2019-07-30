package com.example.kinoapp2;

import com.example.kinoapp2.data.model.Film;
import com.example.kinoapp2.data.model.FilmPojo;
import com.example.kinoapp2.data.model.Films;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;


public interface Service {

    String BASE_URL = "https://s3-eu-west-1.amazonaws.com/sequeniatesttask/films.json";

    @GET()
    Call<Films> getFilms();

//    @GET("")
//    Call<FilmPojo> getFilm(@Url String newslink);
}
