package com.bahmanGhassemieh.movie_application_assignment3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycle = findViewById(R.id.recyclerMovie);
        movieAdapter = new MovieAdapter(movieList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycle.setLayoutManager(layoutManager);
        recycle.setItemAnimator(new DefaultItemAnimator());
        recycle.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        DBClass db = new DBClass(this);
        movieList.addAll(db.getMovies());
        recycle.setAdapter(movieAdapter);


        Button btn_addRecord = findViewById(R.id.btn_mainActivity_addRecord);

        btn_addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Add_Record.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void
    onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
