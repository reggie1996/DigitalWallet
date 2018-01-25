package com.reggie.digitalwallet.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reggie.digitalwallet.Fragment.ChildFragment.Community1RecyclerViewFragment;
import com.reggie.digitalwallet.Fragment.ChildFragment.Community2RecyclerViewFragment;
import com.reggie.digitalwallet.Fragment.ChildFragment.Community3RecyclerViewFragment;
import com.reggie.digitalwallet.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CommunityFragment extends BaseFragment {

    TabLayout tablayout;
    ViewPager viewpager;
    FragmentPagerAdapter adapter;
    private View view;

    private List<String> list_title;

    @Override
    protected View initView() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_community, container, false);

        tablayout = view.findViewById(R.id.tablayout);
        viewpager = view.findViewById(R.id.viewpager);

        list_title = new ArrayList<>();
        list_title.add("热门");
        list_title.add("关注");
        list_title.add("专家");

        adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new Community1RecyclerViewFragment();
                    case 1:
                        return new Community2RecyclerViewFragment();
                    case 2:
                        return new Community3RecyclerViewFragment();
                    default:
                        return new Community1RecyclerViewFragment();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list_title.get(position);
            }
        };

        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);

        return view;
    }

}
