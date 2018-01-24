package com.reggie.digitalwallet.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reggie.digitalwallet.R;

import java.util.List;

/**
 * Created by 24073 on 2018/1/24.
 */

public class CommunityRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    public CommunityRecyclerViewAdapter(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_community, parent, false);
        return new RecyclerView.ViewHolder(view) { };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }
}
