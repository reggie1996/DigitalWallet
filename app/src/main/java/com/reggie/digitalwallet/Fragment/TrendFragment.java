package com.reggie.digitalwallet.Fragment;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Test.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendFragment extends BaseFragment {


    ViewPager mVpTrend;

    List<Fragment> fragments;

    MaterialViewPager materialViewPager;
    ViewPager viewPager;


    @Override
    protected View initView() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trend, container, false);

        materialViewPager = view.findViewById(R.id.materialViewPager);
        viewPager = materialViewPager.getViewPager();
        materialViewPager.getPagerTitleStrip().setTextColorResource(R.color.colorWhite);

        fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new RecyclerViewFragment());
        fragments.add(new RecyclerViewFragment());
        fragments.add(new RecyclerViewFragment());


        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "热门";
                    case 1:
                        return "比特币";
                    case 2:
                        return "以太币";
                    case 3:
                        return "莱特币";
                }
                return "";
            }
        });


        materialViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                Resources resources = mContext.getResources();
                Drawable drawable;
                switch (page) {
                    case 0:
                        drawable = resources.getDrawable(R.drawable.bg_bitcoin);
                        return HeaderDesign.fromColorResAndDrawable(R.color.colorGold1,drawable);
                    case 1:
                        drawable = resources.getDrawable(R.drawable.test);
                        return HeaderDesign.fromColorResAndDrawable(R.color.colorGold1,drawable);
                    case 2:
                        drawable = resources.getDrawable(R.drawable.test);
                        return HeaderDesign.fromColorResAndDrawable(R.color.colorGold1,drawable);
                    case 3:
                        drawable = resources.getDrawable(R.drawable.test);
                        return HeaderDesign.fromColorResAndDrawable(R.color.colorGold1,drawable);
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });


        materialViewPager.getViewPager().setOffscreenPageLimit(materialViewPager.getViewPager().getAdapter().getCount());
        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());

 /*
        mVpTrend.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        */


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
