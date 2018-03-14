package com.reggie.digitalwallet.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.reggie.digitalwallet.Activity.GoodsActivity;
import com.reggie.digitalwallet.Activity.GoodsListActivity;
import com.reggie.digitalwallet.Adapter.GoodsRecyclerViewAdapter;
import com.reggie.digitalwallet.Model.Goods;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Test.TestData;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallFragment extends BaseFragment {


    ImageView iv_mall1;
    ImageView iv_mall2;
    ImageView iv_mall3;
    ImageView iv_store1;
    ImageView iv_store2;
    ImageView iv_store3;
    ImageView iv_store4;
    ImageView iv_store5;
    private View view;

    List<Goods> goodsList;
    RecyclerView rv_goods;

    @Override
    protected View initView() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mall, container, false);
        initImage();
        return view;
    }

    private void initImage() {
        iv_mall1 = view.findViewById(R.id.iv_mall1);
        iv_mall2 = view.findViewById(R.id.iv_mall2);
        iv_mall3 = view.findViewById(R.id.iv_mall3);
        iv_store1 = view.findViewById(R.id.iv_store1);
        iv_store2 = view.findViewById(R.id.iv_store2);
       /* iv_store3 = view.findViewById(R.id.iv_store3);
        iv_store4 = view.findViewById(R.id.iv_store4);
        iv_store5 = view.findViewById(R.id.iv_store5);*/
        Glide.with(this).load(R.mipmap.mall1).into(iv_mall1);
        Glide.with(this).load(R.mipmap.mall2).into(iv_mall2);
        Glide.with(this).load(R.mipmap.mall3).into(iv_mall3);
        Glide.with(this).load(R.mipmap.store1).into(iv_store1);
        Glide.with(this).load(R.mipmap.store2).into(iv_store2);
       /* Glide.with(this).load(R.mipmap.store3).into(iv_store3);
        Glide.with(this).load(R.mipmap.store4).into(iv_store4);
        Glide.with(this).load(R.mipmap.store5).into(iv_store5);*/

        iv_store1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getContext(), GoodsListActivity.class));
            }
        });


        rv_goods = view.findViewById(R.id.rv_goods);

        goodsList = TestData.getGoodsData();
        rv_goods.setLayoutManager(new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        GoodsRecyclerViewAdapter goodsRecyclerViewAdapter = new GoodsRecyclerViewAdapter(getContext(),goodsList);
        goodsRecyclerViewAdapter.setOnItemClickListener(new GoodsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(mContext,GoodsActivity.class));
            }
        });
        rv_goods.setAdapter(goodsRecyclerViewAdapter);
    }



}
