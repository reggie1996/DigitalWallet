package com.reggie.digitalwallet.Model;


import android.os.Parcel;
import android.os.Parcelable;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 24073 on 2018/1/24.
 */

public class News implements Parcelable {
    private String title;
    private String imageUrl;
    private String date;
    private String via;
    private String webUrl;

    public News(String title, String imageUrl, String date, String via, String webUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.date = date;
        this.via = via;
        this.webUrl = webUrl;
    }

    public String getTitle() {
        return title;
    }

    public URL getImageUrl() {
        try {
            return new URL(imageUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getDate() {
        return date;
    }

    public String getVia() {
        return via;
    }

    public URL getWebUrl() {
        try {
            return new URL(webUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", date='" + date + '\'' +
                ", via='" + via + '\'' +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(imageUrl);
        parcel.writeString(date);
        parcel.writeString(via);
        parcel.writeString(webUrl);
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>(){

        @Override
        public News createFromParcel(Parcel parcel) {
            return new News(parcel.readString(),parcel.readString(),parcel.readString(),parcel.readString(),parcel.readString());
        }

        @Override
        public News[] newArray(int i) {
            return new News[i];
        }
    };
}
