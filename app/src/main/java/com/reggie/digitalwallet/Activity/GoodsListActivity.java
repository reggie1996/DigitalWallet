package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.reggie.digitalwallet.Adapter.GoodsRecyclerViewAdapter;
import com.reggie.digitalwallet.Model.Goods;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Test.TestData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsListActivity extends Activity {

    @BindView(R.id.rv_goods)
    RecyclerView rv_goods;

    Context mContext;

    List<Goods> goodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        ButterKnife.bind(this);

        mContext = this;
        goodsList = TestData.getGoodsData();
        rv_goods.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        });
        GoodsRecyclerViewAdapter goodsRecyclerViewAdapter = new GoodsRecyclerViewAdapter(this,goodsList);
        goodsRecyclerViewAdapter.setOnItemClickListener(new GoodsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(mContext,GoodsActivity.class));
            }
        });
        rv_goods.setAdapter(goodsRecyclerViewAdapter);

    }
}
