package com.ganargatul.submtwo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ganargatul.submtwo.MovieTv_Items;
import com.ganargatul.submtwo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MovieTvAdapter extends RecyclerView.Adapter<MovieTvAdapter.MovieViewHolder> {


    Context mContext;
    ArrayList<MovieTv_Items> mMovieTvItems;
    View v;
    OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemCLick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener mListener){
        this.mListener = mListener;
    }

    public MovieTvAdapter(Context mContext, ArrayList<MovieTv_Items> mMovieTvItems) {
        this.mContext = mContext;
        this.mMovieTvItems = mMovieTvItems;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(mContext).inflate(R.layout.movietv_items,viewGroup,false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        MovieTv_Items movieTv_items = mMovieTvItems.get(i);

        movieViewHolder.mTitle.setText(movieTv_items.getTitle());
        Picasso.with(mContext).load(movieTv_items.getPhoto()).into(movieViewHolder.mImage);
    }

    @Override
    public int getItemCount() {
        return mMovieTvItems.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        CircleImageView mImage;
        TextView mTitle;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image_items);
            mTitle = itemView.findViewById(R.id.title_items);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener !=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemCLick(position);
                        }
                    }
                }
            });
        }
    }
}
