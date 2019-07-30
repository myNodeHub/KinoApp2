package com.example.kinoapp2.data.model;

public class Film {

    private String genreName;
    private String filmName;

    public Film(String genreName, String filmName) {
        this.genreName = genreName;
        this.filmName = filmName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
}
