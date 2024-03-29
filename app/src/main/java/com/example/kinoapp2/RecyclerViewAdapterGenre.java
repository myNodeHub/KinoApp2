package com.example.kinoapp2;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kinoapp2.data.model.Film;
import com.example.kinoapp2.data.model.Genre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewAdapterGenre extends RecyclerView.Adapter<RecyclerViewAdapterGenre.ViewHolder> {
    private List<Film> listOfFilms;
    private List<Genre> listOfUnicGenres;
    private List<Film> sortedListOfFilms = new ArrayList<>(); //итоговый массив для setData RecyclerViewAdapterFilm
    private RecyclerViewAdapterFilm recyclerViewAdapterFilm2;
    Context context;
    private int row_index = -1;

    public RecyclerViewAdapterGenre(Context context, RecyclerViewAdapterFilm recyclerViewAdapterFilm2) {
        listOfFilms = new ArrayList<>();
        listOfUnicGenres = new ArrayList<>();
        this.recyclerViewAdapterFilm2 = recyclerViewAdapterFilm2;
        this.context = context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemGenre;
        public CardView cardViewGenre;

        public ViewHolder(View view) {
            super(view);
            itemGenre = view.findViewById(R.id.itemGenre);
            cardViewGenre = view.findViewById(R.id.cardViewGenre);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_item_layout, parent, false);
        RecyclerViewAdapterGenre.ViewHolder viewHolder = new RecyclerViewAdapterGenre.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemGenre.setText(listOfUnicGenres.get(position).getUnicGenre());
        holder.cardViewGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortedListOfFilms.clear();

                Iterator<Film> filmIterator = listOfFilms.iterator(); //по клику на жанр сравниваю его с имеющимися жанрами в listOfFilms
                while (filmIterator.hasNext()) {
                    Film nextFilm = filmIterator.next();

                    for (String genre : nextFilm.getGenres()) {
                        if (genre.equals(listOfUnicGenres.get(position).getUnicGenre())) { //если такой жанр у фильма присутствует,
                            sortedListOfFilms.add(nextFilm); // заполняю им массив sortedListOfFilms
                        }
                    }
                }
                recyclerViewAdapterFilm2.setData(sortedListOfFilms); //и передаю его в recyclerViewAdapterFilm2
                row_index=position; //меняю флаг  для смены цвета на элементе
                notifyDataSetChanged(); //обнавляю
            }
        });
        if(row_index==position){
            holder.cardViewGenre.setBackgroundColor(Color.parseColor("#FFEBCD"));
        }
        else
        {
            holder.cardViewGenre.setBackgroundColor(Color.WHITE);
        }
    }
    @Override
    public int getItemCount() {
        return listOfUnicGenres.size();
    }

    public void setData(List<Film> data) {
        this.listOfFilms.addAll(data);
        notifyDataSetChanged();
    }
    public void setUnicGenre(List<Genre> data) {
        this.listOfUnicGenres.addAll(data);
        notifyDataSetChanged();
    }
}
