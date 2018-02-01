package com.reggie.digitalwallet.Fragment.ChildFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.reggie.digitalwallet.Adapter.CommunityRecyclerViewAdapter;
import com.reggie.digitalwallet.Model.Community;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Test.TestData;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;

/**
 * Created by 24073 on 2018/1/24.
 */

public class Community1RecyclerViewFragment extends Fragment {


    @BindView(R.id.rv_community_child1)
    RecyclerView recyclerView;
    @BindView(R.id.banner_child1)
    Banner banner_child1;

    List<String> bannerImages;
    List<Community> communityList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_community_child1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initData();
        initRecyclerView();
        initBanner();
    }


    private void initData(){

        bannerImages = new ArrayList<>();
        bannerImages.add("http://120.79.17.123/static/img/crowdfunding2.jpg");
        bannerImages.add("http://120.79.17.123/static/img/crowdfunding1.jpg");
        bannerImages.add("http://image11.m1905.cn/uploadfile/2012/0509/20120509110013368.jpg");
        bannerImages.add("http://www.mypcera.com/star/u1/2006/02/22/20060222134251391454.jpg");

        communityList = TestData.getCommunityData1();

    }


    private void initBanner(){
        banner_child1.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });

        banner_child1.setImages(bannerImages);
        banner_child1.setIndicatorGravity(BannerConfig.RIGHT);
        banner_child1.start();
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        recyclerView.setItemAnimator(new ScaleInAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CommunityRecyclerViewAdapter(getContext(),communityList));
    }


}
