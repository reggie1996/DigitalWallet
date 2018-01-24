package com.reggie.digitalwallet.Fragment.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reggie.digitalwallet.Model.News;
import com.reggie.digitalwallet.R;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.reggie.digitalwallet.Adapter.NewsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class NewsRecyclerViewFragment extends Fragment {


    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    List<News> newsList;


    public static final NewsRecyclerViewFragment newInstance(News[] newsList){
        NewsRecyclerViewFragment fragment = new NewsRecyclerViewFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArray("newslist",newsList);
        bundle.putString("test","123213");
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            News[] news = (News[]) getArguments().getParcelableArray("newslist");
            newsList = Arrays.asList(news);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new ScaleInAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(new NewsRecyclerViewAdapter(getContext(),newsList));
    }
}
