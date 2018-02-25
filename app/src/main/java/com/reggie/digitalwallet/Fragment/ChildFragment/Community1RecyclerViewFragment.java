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

import javax.microedition.khronos.opengles.GL;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

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


    private void initData() {

        bannerImages = new ArrayList<>();
        bannerImages.add("https://pic4.zhimg.com/v2-24ef7d28e3fa22297016a9b997854a91_r.jpg");
        bannerImages.add("https://pic4.zhimg.com/043a08fef8da21e474c519985042f3d2_r.jpg");
        bannerImages.add("https://pic1.zhimg.com/80/v2-0b128c4d100f82e061c913e77f6836d9_hd.jpg");
        bannerImages.add("https://pic4.zhimg.com/v2-24ef7d28e3fa22297016a9b997854a91_r.jpg");

        communityList = TestData.getCommunityData1();

    }


    private void initBanner() {
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

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        recyclerView.setItemAnimator(new ScaleInAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CommunityRecyclerViewAdapter(getContext(), communityList));
    }


}
