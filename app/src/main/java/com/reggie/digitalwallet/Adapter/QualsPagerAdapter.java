package com.reggie.digitalwallet.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 24073 on 2018/4/4.
 */

public class QualsPagerAdapter extends PagerAdapter {

    private ArrayList<View> viewLists;

    public QualsPagerAdapter() {
    }

    public QualsPagerAdapter(ArrayList<View> viewLists) {
        super();
        this.viewLists = viewLists;
    }


    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewLists.get(position));
        return viewLists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewLists.get(position));
    }

}
