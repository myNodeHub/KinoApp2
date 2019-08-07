package com.example.kinoapp2.ui.fragments.FragmentListOfFilms;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kinoapp2.MainActivity;
import com.example.kinoapp2.R;
import com.example.kinoapp2.RecyclerViewAdapterFilm;
import com.example.kinoapp2.RecyclerViewAdapterGenre;
import com.example.kinoapp2.Service;
import com.example.kinoapp2.data.model.Film;
import com.example.kinoapp2.data.model.Films;
import com.example.kinoapp2.data.model.Genre;
import com.example.kinoapp2.ui.fragments.FragmentInteractorListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import dagger.android.support.AndroidSupportInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListOfFilms extends Fragment {

    @Inject
    Service service;
    Context context;
    Films films = new Films();

    FragmentInteractorListener fragmentInteractorListener;

    RecyclerView recViwFilm, recViwGenre;
    public RecyclerViewAdapterGenre recyclerViewAdapterGenre;
    public RecyclerViewAdapterFilm recyclerViewAdapterFilm;

    List<Film> filmList = new ArrayList<>();
    List<Genre> sortedGenre = new ArrayList<>();
    private List<String> listOfGenres = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        this.context = context;
        fragmentInteractorListener = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        recViwGenre = view.findViewById(R.id.recViwGenre);
        recViwFilm = view.findViewById(R.id.recViwFilm);

        recyclerViewAdapterFilm = new RecyclerViewAdapterFilm(context.getApplicationContext(), fragmentInteractorListener);
        recViwFilm.setLayoutManager(new GridLayoutManager(context, 2));
        recViwFilm.setAdapter(recyclerViewAdapterFilm); //присвоение рец.вью адаптера

        recyclerViewAdapterGenre = new RecyclerViewAdapterGenre(context.getApplicationContext(), recyclerViewAdapterFilm);
        recViwGenre.setLayoutManager(new LinearLayoutManager(context.getApplicationContext())); //присвоение рец.вью лайоутМэнеджера
        recViwGenre.setAdapter(recyclerViewAdapterGenre); //присвоение рец.вью адаптера

        service.getFilms().enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                films = response.body();
                filmList = films.getFilms();
                Collections.sort(filmList); //сортировка по localized_name


                recyclerViewAdapterFilm.setData(filmList);
                recyclerViewAdapterGenre.setData(filmList);

                for (Film film : filmList) { //прогон по кол-ву фильмов
                    for (String genre : film.getGenres()) {//прогон по кол-ву жанров в каждом фильме
                        listOfGenres.add(genre);
                    }
                }
                Set<String> set = new HashSet<>(listOfGenres); //удаление повторов в листе жанров
                listOfGenres.clear();
                listOfGenres.addAll(set); // лист уникальных стрингов жанров


                for (String s : listOfGenres) {
                    sortedGenre.add(new Genre(s)); //заполняю
                }

                recyclerViewAdapterGenre.setUnicGenre(sortedGenre);
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {

            }
        });
        return view;

    }

}
