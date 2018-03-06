package com.reggie.digitalwallet.Model;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 24073 on 2018/3/6.
 */

public class Specialist {
    private String name;
    private String desc;
    private int cost;
    private String imgUrl;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getCost() {
        return cost;
    }

    public URL getImgUrl() {
        try {
            return new URL(imgUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Specialist(String name, String desc, int cost, String imgUrl) {

        this.name = name;
        this.desc = desc;
        this.cost = cost;
        this.imgUrl = imgUrl;
    }
}
