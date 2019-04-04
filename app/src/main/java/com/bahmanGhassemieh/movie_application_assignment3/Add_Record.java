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

    }
}
