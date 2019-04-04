package com.bahmanGhassemieh.movie_application_assignment3;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class Add_Record extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__record);

        Button btnSave = findViewById(R.id.btn_addRecord_save);
        Button btnCancel = findViewById(R.id.btn_addRecord_Cancel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBClass dbClass = new DBClass(getApplicationContext());

                EditText edMovieName = findViewById(R.id.edtxt_addRecord_movieName);
                EditText edMovieDescription = findViewById(R.id.edM_addRecord_showDescription);
                RatingBar rBar = findViewById(R.id.rb_addRecord_movieRating);

                Movie movie = new Movie(
                        edMovieName.getText().toString(),
                        edMovieDescription.getText().toString(),
                        Float.valueOf(rBar.getRating()), true);


                dbClass.addRecord(movie);
                Intent data = new Intent();
                setResult(RESULT_OK, data);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                setResult(RESULT_CANCELED, data);
                finish();
            }
        });
    }
}
