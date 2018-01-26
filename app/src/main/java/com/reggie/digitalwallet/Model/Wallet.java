package com.reggie.digitalwallet.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by 24073 on 2018/1/26.
 */

public class Wallet implements Parcelable {
    private String headUrl;
    private String name;
    private double balance;
    private String pk;

    public Wallet(String headUrl, String name, double balance, String pk) {
        this.headUrl = headUrl;
        this.name = name;
        this.balance = balance;
        this.pk = pk;
    }

    public URL getHeadUrl()
    {
        try {
            return new URL(headUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getPk() {
        return pk;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "headUrl='" + headUrl + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", pk='" + pk + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(headUrl);
        parcel.writeString(name);
        parcel.writeDouble(balance);
        parcel.writeString(pk);

    }

    public static final Parcelable.Creator<Wallet> CREATOR = new Parcelable.Creator<Wallet>(){

        @Override
        public Wallet createFromParcel(Parcel parcel) {
            return new Wallet(parcel.readString(),parcel.readString(),parcel.readDouble(),parcel.readString());
        }

        @Override
        public Wallet[] newArray(int i) {
            return new Wallet[i];
        }
    };
}

