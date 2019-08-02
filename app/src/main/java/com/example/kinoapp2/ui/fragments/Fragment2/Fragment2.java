package com.example.kinoapp2.ui.fragments.Fragment2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kinoapp2.R;
import com.example.kinoapp2.data.model.Film;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    TextView textView;
    Film film;

    public Fragment2() {
        this.film = new Film();
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
        textView = (TextView) view.findViewById(R.id.frag2);
        textView.setText(this.film.getDescription());
        return view;
    }
    public void setFilm(Film film) {
        this.film = film;
    }
}
