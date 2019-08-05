package com.example.kinoapp2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.kinoapp2.ui.fragments.FragmentInteractorListener;
import com.example.kinoapp2.data.model.Film;
import com.squareup.picasso.Picasso;

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
        public ImageView card_view_image;

        public ViewHolder(View view) {
            super(view);
            itemFilm = view.findViewById(R.id.itemFilm);
            cardViewFilm = view.findViewById(R.id.cardViewFilm);
            card_view_image = view.findViewById(R.id.card_view_image);
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

        final Film theFilm = listOfFilms.get(position);

        Picasso.with(context).load(theFilm.getImageUrl())
                .placeholder(context.getResources().getDrawable(R.drawable.moviedefolt))
                .error(context.getResources().getDrawable(R.drawable.moviedefolt)).into(holder.card_view_image);

        holder.itemFilm.setText(listOfFilms.get(position).getLocalizedName());

        holder.cardViewFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("LocalizedName", listOfFilms.get(position).getLocalizedName());
                bundle.putString("Name", listOfFilms.get(position).getName());
                bundle.putInt("Year", listOfFilms.get(position).getYear());
                bundle.putString("Rating", listOfFilms.get(position).getRating());
                bundle.putString("Description", listOfFilms.get(position).getDescription());
                bundle.putString("ImageUrl", listOfFilms.get(position).getImageUrl());

                fragmentInteractorListener.setBundle(bundle);
            }
        });
    }
    @Override
    public int getItemCount() {
        return listOfFilms.size();
    }

    public void setData(List<Film> data) {
        listOfFilms.clear();
        this.listOfFilms.addAll(data);
        notifyDataSetChanged();
    }
}
