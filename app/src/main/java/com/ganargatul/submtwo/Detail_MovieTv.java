package com.ganargatul.submtwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class Detail_MovieTv extends AppCompatActivity {

    TextView title,desc;
    ImageView photo;
    public static final String  EXTRA_MOVIETV="EXTRA MOVIE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__movie_tv);
        MovieTv_Items movieTv_items = getIntent().getParcelableExtra(EXTRA_MOVIETV);

        title=findViewById(R.id.title_detail);
        desc=findViewById(R.id.desc_detail);
        photo=findViewById(R.id.image_detail);

        title.setText(movieTv_items.getTitle());
        desc.setText(movieTv_items.getDesc());
        Picasso.with(this).load(movieTv_items.getPhoto()).into(photo);
    }
}
