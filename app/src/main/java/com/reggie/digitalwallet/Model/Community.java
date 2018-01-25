package com.reggie.digitalwallet.Model;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 24073 on 2018/1/25.
 */

public class Community {
    private String headUrl;
    private String name;
    private String date;
    private String text;
    private String imageUrl;
    private int likeNum;
    private int commentNum;
    private int shareNum;

    public Community(String headUrl, String name, String date, String text, String imageUrl, int likeNum, int commentNum, int shareNum) {
        this.headUrl = headUrl;
        this.name = name;
        this.date = date;
        this.text = text;
        this.imageUrl = imageUrl;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
        this.shareNum = shareNum;
    }

    public URL getHeadUrl() {
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

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public URL getImageUrl() {
        try {
            return new URL(imageUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public int getShareNum() {
        return shareNum;
    }
}
