package com.ganargatul.submtwo;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieTv_Items implements Parcelable {
    String title,desc;
    int photo;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getPhoto() {
        return photo;
    }

    public MovieTv_Items(String title, String desc, int photo) {
        this.title = title;
        this.desc = desc;
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.desc);
        dest.writeInt(this.photo);
    }

    protected MovieTv_Items(Parcel in) {
        this.title = in.readString();
        this.desc = in.readString();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<MovieTv_Items> CREATOR = new Parcelable.Creator<MovieTv_Items>() {
        @Override
        public MovieTv_Items createFromParcel(Parcel source) {
            return new MovieTv_Items(source);
        }

        @Override
        public MovieTv_Items[] newArray(int size) {
            return new MovieTv_Items[size];
        }
    };
}
