package com.reggie.digitalwallet.Model;

/**
 * Created by 24073 on 2018/3/14.
 */

public class Goods {
    private String name;
    private int img;
    private float cost;

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public float getCost() {
        return cost;
    }

    public Goods(String name, int img, float cost) {
        this.name = name;
        this.img = img;
        this.cost = cost;
    }

    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", img=" + img +
                ", cost=" + cost +
                '}';
    }
}
