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
import com.reggie.digitalwallet.Model.News;
import com.reggie.digitalwallet.Model.Specialist;
import com.reggie.digitalwallet.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class SpecialistRecyclerViewAdapter extends RecyclerView.Adapter<SpecialistRecyclerViewAdapter.ViewHolder> implements View.OnClickListener{

    List<Specialist> Specialists;
    Context mContext;

    private OnItemClickListener mItemClickListener = null;


    public SpecialistRecyclerViewAdapter(Context context, List<Specialist> Specialists) {
        this.mContext = context;
        this.Specialists = Specialists;
    }

    @Override
    public int getItemCount() {
        return Specialists.size();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_studyroom, parent, false);
        ViewHolder vh = new ViewHolder(view);

        view.setOnClickListener(this);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Specialist specialist = Specialists.get(position);
        holder.tv_name.setText("专家名：" + specialist.getName());
        holder.tv_describe.setText("简介：" + specialist.getDesc());
        holder.tv_cost.setText("咨询费用：" + specialist.getCost());
        Glide.with(mContext).load(specialist.getImgUrl()).into(holder.iv_img);
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
        @BindView(R.id.tv_coursename)
        TextView tv_name;
        @BindView(R.id.tv_describe)
        TextView tv_describe;
        @BindView(R.id.tv_hostName)
        TextView tv_cost;
        @BindView(R.id.iv_cover)
        ImageView iv_img;

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