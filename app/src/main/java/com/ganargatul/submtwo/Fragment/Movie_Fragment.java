package com.ganargatul.submtwo.Fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ganargatul.submtwo.Adapter.MovieTvAdapter;
import com.ganargatul.submtwo.Detail_MovieTv;
import com.ganargatul.submtwo.MovieTv_Items;
import com.ganargatul.submtwo.R;

import java.util.ArrayList;

import static com.ganargatul.submtwo.Detail_MovieTv.EXTRA_MOVIETV;

/**
 * A simple {@link Fragment} subclass.
 */
public class Movie_Fragment extends Fragment implements MovieTvAdapter.OnItemClickListener {

    View v;
    RecyclerView mRecyclerView;
    MovieTvAdapter mMovieTvAdapter;
    ArrayList<MovieTv_Items> mMovieTvItems;
    String[]title,desc;
    TypedArray photo;

    public Movie_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_movie, container, false);
        mRecyclerView = v.findViewById(R.id.movie_recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mMovieTvItems = new ArrayList<>();
        Prepare();
        Show();
        return v;
    }

    private void Show() {
        for(int i = 0; i<title.length;i++){
            MovieTv_Items movieTv_items = new MovieTv_Items(title[i],desc[i],photo.getResourceId(i,-1));
            mMovieTvItems.add(movieTv_items);
        }
        mMovieTvAdapter = new MovieTvAdapter(getContext(),mMovieTvItems);
        mMovieTvAdapter.setOnItemClickListener(Movie_Fragment.this);
        mRecyclerView.setAdapter(mMovieTvAdapter);
    }

    private void Prepare() {
        title = getResources().getStringArray(R.array.movie_title);
        desc = getResources().getStringArray(R.array.movie_desc);
        photo = getResources().obtainTypedArray(R.array.photo_movie);
    }

    @Override
    public void onItemCLick(int position) {
        MovieTv_Items movieTv_items = new MovieTv_Items(mMovieTvItems.get(position).getTitle(),mMovieTvItems.get(position).getDesc(),mMovieTvItems.get(position).getPhoto());

        Intent detail = new Intent(getContext(), Detail_MovieTv.class);

        detail.putExtra(EXTRA_MOVIETV,movieTv_items);
        startActivity(detail);
    }
}
