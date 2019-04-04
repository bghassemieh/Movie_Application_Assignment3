package com.bahmanGhassemieh.movie_application_assignment3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBClass extends SQLiteOpenHelper {

    public static int DATABASE_VERSION = 1;

    public DBClass (Context context){
        super(context, Movie.TABLE_NAME, null, DATABASE_VERSION);
    }

    public Movie addRecord(Movie m)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Movie.COLUMN_NAME, m.getMovie_name());
        values.put(Movie.COLUMN_DESCRIPTION, m.getMovie_description());
        values.put(Movie.COLUMN_RATING, m.getMovie_rating());
        values.put(Movie.COLUMN_ACTIVE, m.getMovie_active_flag());

        db.insert(Movie.TABLE_NAME, null, values);
        return m;
    }

    public List<Movie> getMovies(){

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "select * from " + Movie.TABLE_NAME;

        Cursor c = db.rawQuery(selectQuery, null);

        List<Movie> movList = new ArrayList<>();

        if(c.moveToFirst())
        {
            do {
                Movie foundMovie = new Movie();
                foundMovie.setMovieId(c.getInt(c.getColumnIndex(Movie.COLUMN_ID)));
                foundMovie.setMovie_name(c.getString(c.getColumnIndex(Movie.COLUMN_NAME)));
                foundMovie.setMovie_description(c.getString(c.getColumnIndex(Movie.COLUMN_DESCRIPTION)));
                foundMovie.setMovie_rating(c.getFloat(c.getColumnIndex(Movie.COLUMN_RATING)));
                foundMovie.setMovie_active_flag(c.getInt(c.getColumnIndex(Movie.COLUMN_ACTIVE)) !=0);

                movList.add(foundMovie);

            }while(c.moveToNext());
        }
        db.close();
        return movList;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Movie.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
