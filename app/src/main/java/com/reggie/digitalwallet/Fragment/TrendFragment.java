package com.reggie.digitalwallet.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reggie.digitalwallet.Fragment.ChildFragment.TreadChild1Fragment;
import com.reggie.digitalwallet.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendFragment extends BaseFragment {


    List<Fragment> fragments;
    @BindView(R.id.vp_trend)
    ViewPager mVpTrend;
    private View view;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("onCreateView","1111111");
        unbinder = ButterKnife.bind(this, inflater.inflate(R.layout.fragment_trend, container, false));
        initView();
        return inflater.inflate(R.layout.fragment_trend, container, false);
    }

    private void initView() {

        fragments = new ArrayList<>();
        fragments.add(new TreadChild1Fragment());
        fragments.add(new TreadChild1Fragment());

        mVpTrend.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);

            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
