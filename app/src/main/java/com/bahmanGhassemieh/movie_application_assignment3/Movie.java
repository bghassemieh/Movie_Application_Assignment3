package com.bahmanGhassemieh.movie_application_assignment3;

import java.io.Serializable;

public class Movie implements Serializable {

    public static final String TABLE_NAME = "movie";

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_RATING = "rating";
    public static final String COLUMN_ACTIVE = "active";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KET AUTOINCREMENT," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_DESCRIPTION + " TEXT," +
                    COLUMN_RATING + " FLOat," +
                    COLUMN_ACTIVE + " INTEGER)";

    private int movieId;
    private String movie_name;
    private String movie_description;
    private float movie_rating;
    private boolean movie_active_flag;

    public Movie(String movie_name, String movie_description, float movie_rating, boolean movie_active_flag) {
        this.movie_name = movie_name;
        this.movie_description = movie_description;
        this.movie_rating = movie_rating;
        this.movie_active_flag = movie_active_flag;
    }

    public Movie(){

    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_description() {
        return movie_description;
    }

    public void setMovie_description(String movie_description) {
        this.movie_description = movie_description;
    }

    public float getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(float movie_rating) {
        this.movie_rating = movie_rating;
    }

    public boolean getMovie_active_flag() {
        return movie_active_flag;
    }

    public void setMovie_active_flag(boolean movie_active_flag) {
        this.movie_active_flag = movie_active_flag;
    }
}
