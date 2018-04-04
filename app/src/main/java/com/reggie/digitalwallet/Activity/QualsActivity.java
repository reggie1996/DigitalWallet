package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.reggie.digitalwallet.Adapter.QualsPagerAdapter;
import com.reggie.digitalwallet.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 区块链资格测试
 */
public class QualsActivity extends Activity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private ArrayList<View> qList;
    QualsPagerAdapter qualsPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quals);
        ButterKnife.bind(this);

        qList = new ArrayList<>();
        qList.add(getLayoutInflater().inflate(R.layout.item_q1,null,false));
        qList.add(getLayoutInflater().inflate(R.layout.item_q2,null,false));
        qList.add(getLayoutInflater().inflate(R.layout.item_q3,null,false));
        qualsPagerAdapter = new QualsPagerAdapter(qList);
        viewpager.setAdapter(qualsPagerAdapter);
    }
}
