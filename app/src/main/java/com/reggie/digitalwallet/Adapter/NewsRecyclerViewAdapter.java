package com.reggie.digitalwallet.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.reggie.digitalwallet.Model.News;
import com.reggie.digitalwallet.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> implements View.OnClickListener{

    List<News> newsList;
    Context mContext;

    private OnItemClickListener mItemClickListener = null;


    public NewsRecyclerViewAdapter(Context context, List<News> newsList) {
        this.mContext = context;
        this.newsList = newsList;
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card_news, parent, false);
        ViewHolder vh = new ViewHolder(view);

        view.setOnClickListener(this);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.tv_news_title.setText(news.getTitle());
        holder.tv_news_date.setText(news.getDate());
        holder.tv_news_via.setText("via: " + news.getVia());
        Glide.with(mContext).load(news.getImageUrl()).into(holder.iv_news_image);
        holder.itemView.setTag(position);
    }


    @Override
    public void onClick(View view) {
        if (mItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_news_title)
        TextView tv_news_title;
        @BindView(R.id.tv_news_date)
        TextView tv_news_date;
        @BindView(R.id.tv_news_via)
        TextView tv_news_via;
        @BindView(R.id.iv_news_image)
        ImageView iv_news_image;
        @BindView(R.id.card_view)
        CardView mCardView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

}