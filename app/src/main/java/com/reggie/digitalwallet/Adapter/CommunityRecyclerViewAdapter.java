package com.reggie.digitalwallet.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.reggie.digitalwallet.Model.Community;
import com.reggie.digitalwallet.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 24073 on 2018/1/24.
 */

public class CommunityRecyclerViewAdapter extends RecyclerView.Adapter<CommunityRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    List<Community> communityList;

    public CommunityRecyclerViewAdapter(Context context, List<Community> contents) {
        this.mContext = context;
        this.communityList = contents;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_community, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Community community = communityList.get(position);
        Glide.with(mContext).load(community.getHeadUrl()).into(holder.iv_community_head);
        holder.tv_community_name.setText(community.getName());
        holder.tv_community_date.setText(community.getDate());
        holder.tv_community_text.setText(community.getText());
        Glide.with(mContext).load(community.getImageUrl()).into(holder.iv_community_image);
        holder.tv_community_like.setText(community.getLikeNum()+"");
        holder.tv_community_comment.setText(community.getCommentNum()+"");
        holder.tv_community_share.setText(community.getShareNum()+"");
    }

    @Override
    public int getItemCount() {
        return communityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_community_head)
        CircleImageView iv_community_head;
        @BindView(R.id.tv_community_name)
        TextView tv_community_name;
        @BindView(R.id.tv_community_date)
        TextView tv_community_date;
        @BindView(R.id.tv_community_text)
        TextView tv_community_text;
        @BindView(R.id.iv_community_image)
        ImageView iv_community_image;
        @BindView(R.id.tv_community_like)
        TextView tv_community_like;
        @BindView(R.id.tv_community_comment)
        TextView tv_community_comment;
        @BindView(R.id.tv_community_share)
        TextView tv_community_share;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
