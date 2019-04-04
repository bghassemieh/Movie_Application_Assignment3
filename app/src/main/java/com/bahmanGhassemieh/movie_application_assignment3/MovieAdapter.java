package com.bahmanGhassemieh.movie_application_assignment3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    List<Movie> movieList;

    class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView displayId, displayName, displayDescription;
        RatingBar displayRbar;
        ImageButton displayBtnDelete;

          MyViewHolder(View view)
          {
            super(view);

            displayId = view.findViewById(R.id.txt_movieRow_showID);
            displayName = view.findViewById(R.id.txt_movieRow_showName);
            displayDescription = view.findViewById(R.id.txt_movieRow_showDescription);
            displayRbar = view.findViewById(R.id.ratingBar_movieRow_showRating);
            displayBtnDelete = view.findViewById(R.id.imageButton_movieRow_ShowBtnDelete);
          }
    }
    MovieAdapter(List<Movie> movieList)
    {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_row_layout,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder viewHolder, int i) {
        final Movie movie = movieList.get(i);

        viewHolder.displayId.setText(String.valueOf((movie.getMovieId())));
        viewHolder.displayName.setText(String.valueOf(movie.getMovie_name()));
        viewHolder.displayDescription.setText(String.valueOf(movie.getMovie_description()));
        viewHolder.displayRbar.setRating(movie.getMovie_rating());

    }

    @Override
    public int getItemCount() {
        return this.movieList.size();
    }


}
