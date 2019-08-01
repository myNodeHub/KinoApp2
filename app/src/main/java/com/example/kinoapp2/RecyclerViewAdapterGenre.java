package com.example.kinoapp2;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.kinoapp2.data.model.Film;
import com.example.kinoapp2.data.model.Genre;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RecyclerViewAdapterGenre extends RecyclerView.Adapter<RecyclerViewAdapterGenre.ViewHolder> {
    private List<Film> listOfFilms;
    private List<Genre> listOfUnicGenres;

    private List<Film> sortedListOfFilms = new ArrayList<>(); //итог для сетдаты 2го адаптера

    private RecyclerViewAdapterFilm recyclerViewAdapterFilm2;
    Context context;

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

//        final PojoNewsLatest theList = listOfGenre.get(position);
//        if (theList.getTitleImage().getUrl() != null) {
//        Picasso.with(context).load(theList.getTitleImage().getUrl()).into(holder.card_view_image);
//    }


//        holder.itemGenre.setText("Жанр: " + listOfFilms.get(position).getGenres());
        holder.itemGenre.setText("Жанр: " + listOfUnicGenres.get(position).getUnicGenre());

        String s = listOfUnicGenres.get(position).getUnicGenre();
        System.out.println("!!!!!!222222 s");



//        holder.txtInfoRightcol.setText(theList.getInfo().getRightcol());
        holder.cardViewGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortedListOfFilms.clear();

                Iterator<Film> filmIterator = listOfFilms.iterator();
                while (filmIterator.hasNext()) {
                    Film nextFilm = filmIterator.next();

                    for (String genre : nextFilm.getGenres()) {
                        if (genre.equals(listOfUnicGenres.get(position).getUnicGenre())) {
                            System.out.println("&&&&&&&&&&" + nextFilm);
                            sortedListOfFilms.add(nextFilm);
                        }
                    }


                }
                recyclerViewAdapterFilm2.setData(sortedListOfFilms);


            }
    });
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
