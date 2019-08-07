package com.example.kinoapp2.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Film implements Parcelable, Comparable<Film> {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("localized_name")
    @Expose
    private String localizedName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("genres")
    @Expose
    private List<String> genres = new ArrayList<>();

    public Film() {
    }

    public Film(Integer id, String localizedName, String name, Integer year,
                String rating, String imageUrl, String description, List<String> genres) {
        this.id = id;
        this.localizedName = localizedName;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.description = description;
        this.genres = genres;
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel parcel) {

            Integer id = parcel.readInt();
            String localizedName = parcel.readString();
            String name = parcel.readString();
            Integer year = parcel.readInt();
            String rating = parcel.readString();
            String imageUrl = parcel.readString();
            String description = parcel.readString();
            List <String> genres = new ArrayList<>();
            parcel.readList(genres, String.class.getClassLoader());

            return new Film(id, localizedName, name, year, rating, imageUrl, description, genres);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRating() {   // public Object getRating() {
        return rating;
    }

    public void setRating(String rating) {  //public void setRating(Object rating) {
        this.rating = rating;
    }

    public String getImageUrl() {      // public Object getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {   // public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(localizedName);
        dest.writeString(name);
        dest.writeInt(year);
        dest.writeString(rating);
        dest.writeString(imageUrl);
        dest.writeString(description);
        dest.writeList(genres);
    }

    @Override
    public int compareTo(Film o) {
        int result = this.localizedName.compareTo(o.localizedName);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", localizedName= " + localizedName +
                ", name= " + name +
                ", year= " + year +
                ", rating= " + rating +
                ", imageUrl= " + imageUrl +
                ", description= " + description +
                ", genres='" + genres + '\'' +
                '}';
    }
}