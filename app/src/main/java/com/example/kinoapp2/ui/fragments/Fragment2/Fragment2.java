package com.example.kinoapp2.ui.fragments.Fragment2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.kinoapp2.R;
import com.example.kinoapp2.data.model.Film;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Fragment2 extends Fragment {
    TextView localized_name_tv, backArrow_tv, name_tv, year_tv, rating_tv, description_tv;
    ImageView image_url_tv;
    public static Film film;

    public Fragment2 () {
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        backArrow_tv = view.findViewById(R.id.backArrow_tv);

        backArrow_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });
        image_url_tv = view.findViewById(R.id.image_url_tv);
        localized_name_tv = view.findViewById(R.id.localized_name_tv);
        name_tv = view.findViewById(R.id.name_tv);
        year_tv = view.findViewById(R.id.year_tv);
        rating_tv = view.findViewById(R.id.rating_tv);
        description_tv = view.findViewById(R.id.description_tv);

        localized_name_tv.setText(film.getLocalizedName());
        name_tv.setText(film.getName());
        year_tv.setText("Год: "+ film.getYear());
        if (film.getRating() != null){
            rating_tv.setText(film.getRating());
        }else  rating_tv.setText(" - ");
        if (film.getDescription() != null){
            description_tv.setText(film.getDescription());
        }else  description_tv.setText("Описание отсутствует.");

        Glide.with(getContext())
                .load(film.getImageUrl())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.moviedefolt)
                .fitCenter())
                .override(750,750)
                .into(image_url_tv);

        return view;
    }
    public void setFilmBundle(Bundle bundle) {
        Film film = bundle.getParcelable("filmParcelable");
        System.out.println("777" + film);
        this.film = film;
    }
}
