package com.reggie.digitalwallet.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.reggie.digitalwallet.Model.Goods;
import com.reggie.digitalwallet.Model.News;
import com.reggie.digitalwallet.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class GoodsRecyclerViewAdapter extends RecyclerView.Adapter<GoodsRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    List<Goods> goodsList;
    Context mContext;

    private OnItemClickListener mItemClickListener = null;


    public GoodsRecyclerViewAdapter(Context context, List<Goods> goodsList) {
        this.mContext = context;
        this.goodsList = goodsList;
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_goods, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Goods goods = goodsList.get(position);
        holder.tv_goods_name.setText(goods.getName());
        holder.tv_goods_cost.setText(goods.getCost()+"");
        Glide.with(mContext).load(goods.getImg()).into(holder.iv_goods_img);
        holder.itemView.setTag(position);
    }


    @Override
    public void onClick(View view) {
        if (mItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }


    static

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_goods_img)
        ImageView iv_goods_img;
        @BindView(R.id.tv_goods_name)
        TextView tv_goods_name;
        @BindView(R.id.tv_goods_cost)
        TextView tv_goods_cost;

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