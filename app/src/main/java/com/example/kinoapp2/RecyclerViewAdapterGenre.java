package com.example.kinoapp2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kinoapp2.data.model.Film;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RecyclerViewAdapterGenre extends RecyclerView.Adapter<RecyclerViewAdapterGenre.ViewHolder> {
//    private List<Genre> listOfGenre;
    private List<Film> listOfFilms;
    private List<Film> sortedListOfFilms = new ArrayList<>();
    private RecyclerViewAdapterFilm recyclerViewAdapterFilm2;
    Context context;


    public RecyclerViewAdapterGenre(Context context, RecyclerViewAdapterFilm recyclerViewAdapterFilm2) {
//        listOfGenre = new ArrayList<>();
        listOfFilms = new ArrayList<>();
        this.recyclerViewAdapterFilm2 =  recyclerViewAdapterFilm2;
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

//        final PojoNewsLatest theList = listOfGenre.get(position);
//        if (theList.getTitleImage().getUrl() != null) {
//        Picasso.with(context).load(theList.getTitleImage().getUrl()).into(holder.card_view_image);
//    }
        holder.itemGenre.setText("Жанр: " + listOfFilms.get(position).getGenres());
//        holder.txtInfoRightcol.setText(theList.getInfo().getRightcol());
        holder.cardViewGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                sortedListOfFilms.clear();

//   //записываю в отдельный массив все жанры(здесь или в мейнАк), и тоже самое

//                Iterator<Film> filmIterator = listOfFilms.iterator();//создаем итератор
//                while (filmIterator.hasNext()) {//до тех пор, пока в списке есть элементы
//
//                    Film nextFilm = filmIterator.next();//получаем следующий элемент
//                    if (nextFilm.getGenreName().equals(listOfGenre.get(position).getGenreName())) {
//                        System.out.println("&&&&&&&&&&" + nextFilm);
//                        sortedListOfFilms.add(nextFilm);
//                    }
//                }
//                System.out.println(sortedListOfFilms + "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
//                recyclerViewAdapterFilm2.setData(sortedListOfFilms);
//
//                for (int i = 0; i < sortedListOfFilms.size(); i++)
//                    System.out.println("!!!!!!!!!!!!!!!!  " + sortedListOfFilms.get(i).getFilmName() + "  !!!!!!!!!!!!!!!!!!!!!");
//                    System.out.println("------------------------------------------");


            }
        });
    }

    @Override
//    public int getItemCount() {
//        return listOfGenre.size();
//    }
    public int getItemCount() {
        return listOfFilms.size();
    }

    public void setData(List<Film> data) {
        this.listOfFilms.addAll(data);
        notifyDataSetChanged();
    }

//    public void setDataFilm(List<Film> data) {
//        this.listOfFilms.addAll(data);
//        notifyDataSetChanged();
//    }
}
