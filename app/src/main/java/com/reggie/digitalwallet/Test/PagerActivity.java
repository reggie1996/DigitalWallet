package com.reggie.digitalwallet.Test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.reggie.digitalwallet.Fragment.ChildFragment.TreadChild1Fragment;
import com.reggie.digitalwallet.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagerActivity extends FragmentActivity {

    @BindView(R.id.test_pager)
    ViewPager mTestPager;
    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ButterKnife.bind(this);

        fragments = new ArrayList<>();
        fragments.add(new TreadChild1Fragment());
        fragments.add(new TreadChild1Fragment());

        mTestPager.setAdapter(new FragmentPagerAdapter(getApplication()) {
            @Override
            public Fragment getItem(int position) {
                return null;
            }

            @Override
            public int getCount() {
                return 0;
            }
        });
    }
}
