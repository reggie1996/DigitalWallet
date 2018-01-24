package com.reggie.digitalwallet.Fragment.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;

import com.reggie.digitalwallet.Adapter.CommunityRecyclerViewAdapter;
import com.reggie.digitalwallet.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;

/**
 * Created by 24073 on 2018/1/24.
 */

public class Community1RecyclerViewFragment extends Fragment {

    private static final int ITEM_COUNT = 20;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        final List<Object> items = new ArrayList<>();
        for (int i = 0; i < ITEM_COUNT; ++i) {
            items.add(new Object());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new ScaleInAnimator());
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(new CommunityRecyclerViewAdapter(items));
    }
}
