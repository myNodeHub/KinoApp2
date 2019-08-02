package com.example.kinoapp2;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kinoapp2.data.model.Film;
import com.example.kinoapp2.ui.fragments.FragmentInteractorListener;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapterFilm extends RecyclerView.Adapter<RecyclerViewAdapterFilm.ViewHolder> {
    private List<Film> listOfFilms;
    Context context;
    private FragmentInteractorListener fragmentInteractorListener;

    public RecyclerViewAdapterFilm(Context context, FragmentInteractorListener fragmentInteractorListener) {

        listOfFilms = new ArrayList<>();
        this.context= context;
        this.fragmentInteractorListener = fragmentInteractorListener;

    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemFilm;
        public CardView cardViewFilm;

        public ViewHolder(View view) {
            super(view);
            itemFilm = view.findViewById(R.id.itemFilm);
            cardViewFilm = view.findViewById(R.id.cardViewFilm);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item_layout, parent, false);
        RecyclerViewAdapterFilm.ViewHolder viewHolder = new RecyclerViewAdapterFilm.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        final PojoNewsLatest theList = listOfFilms.get(position);
//        if (theList.getTitleImage().getUrl() != null) {
//        Picasso.with(context).load(theList.getTitleImage().getUrl()).into(holder.card_view_image);
//    }
        holder.itemFilm.setText("Фильм: " + listOfFilms.get(position).getLocalizedName());
//        holder.itemGenre.setText("Жанр: ");
//        holder.txtInfoRightcol.setText(theList.getInfo().getRightcol());
        holder.cardViewFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentInteractorListener.setFilm(listOfFilms.get(position));


            }
        });
    }
    @Override
    public int getItemCount() {
        return listOfFilms.size();
    }

    public void setData(List<Film> data) {
//        notifyDataSetChanged();
        listOfFilms.clear();
        System.out.println("())))))))))))()()())()()()()( "+ data);
        this.listOfFilms.addAll(data);
        notifyDataSetChanged();

    }
}
