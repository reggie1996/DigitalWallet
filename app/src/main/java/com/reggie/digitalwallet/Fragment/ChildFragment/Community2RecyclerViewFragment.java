package com.reggie.digitalwallet.Fragment.ChildFragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reggie.digitalwallet.Adapter.CommunityRecyclerViewAdapter;
import com.reggie.digitalwallet.Model.Community;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Test.TestData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGAStickinessRefreshViewHolder;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;

import static java.lang.Thread.sleep;

/**
 * A simple {@link Fragment} subclass.
 */
public class Community2RecyclerViewFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate{

    @BindView(R.id.rv_community_child2)
    RecyclerView rv_community_child2;
    private BGARefreshLayout mRefreshLayout;
    List<Community> communityList;
    CommunityRecyclerViewAdapter communityRecyclerViewAdapter;
    View view;
    View new_moment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_community_child2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        this.view = view;

        communityList = TestData.getCommunityData1();

        rv_community_child2.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rv_community_child2.setItemAnimator(new ScaleInAnimator());
        rv_community_child2.setHasFixedSize(true);
        communityRecyclerViewAdapter = new CommunityRecyclerViewAdapter(getContext(), communityList);
        rv_community_child2.setAdapter(communityRecyclerViewAdapter);

        initRefreshLayout(mRefreshLayout);

    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mRefreshLayout.endRefreshing();
                            new_moment.setVisibility(View.VISIBLE);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return true;
    }

    private void initRefreshLayout(BGARefreshLayout refreshLayout) {
        mRefreshLayout =  view.findViewById(R.id.rl_modulename_refresh);
        // 为BGARefreshLayout 设置代理
        mRefreshLayout.setDelegate(this);

        BGAStickinessRefreshViewHolder stickinessRefreshViewHolder = new BGAStickinessRefreshViewHolder(getContext(), true);
        stickinessRefreshViewHolder.setStickinessColor(R.color.colorGold2);
        stickinessRefreshViewHolder.setRotateImage(R.drawable.refreshing);
        mRefreshLayout.setRefreshViewHolder(stickinessRefreshViewHolder);

        new_moment = view.findViewById(R.id.item_new_moment);

    }

}
