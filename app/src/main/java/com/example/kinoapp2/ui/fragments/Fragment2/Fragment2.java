package com.example.kinoapp2.ui.fragments.Fragment2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.kinoapp2.R;
import com.squareup.picasso.Picasso;

public class Fragment2 extends Fragment {
    TextView localized_name_tv, backArrow_tv, name_tv, year_tv, rating_tv, description_tv;
    ImageView image_url_tv;
    public static Bundle bundleFr;

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

        localized_name_tv.setText(bundleFr.getString("LocalizedName"));
        name_tv.setText(bundleFr.getString("Name"));
        year_tv.setText("Год: "+ bundleFr.getInt("Year"));
        rating_tv.setText(bundleFr.getString("Rating"));
        if (bundleFr.getString("Description") != null){
            description_tv.setText(bundleFr.getString("Description"));
        }else  description_tv.setText("Описание отсутствует.");

        Picasso.with(getContext()).load(bundleFr.getString("ImageUrl"))
                .placeholder(getContext().getResources().getDrawable(R.drawable.moviedefolt))
                .error(getContext().getResources().getDrawable(R.drawable.moviedefolt)).into(image_url_tv);

        return view;
    }

    public void setFilmBundle(Bundle bundle) {

        bundleFr = bundle;
    }


}
