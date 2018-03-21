package com.reggie.digitalwallet.Fragment.ChildFragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.reggie.digitalwallet.Model.Specialist;
import com.reggie.digitalwallet.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Community3RecyclerViewFragment extends Fragment {

    @BindView(R.id.rv_community_child3)
    RecyclerView rv_community_child3;
    List<Specialist> specialistList;
    @BindView(R.id.iv_article1)
    ImageView iv_article1;
    @BindView(R.id.iv_article2)
    ImageView iv_article2;
    @BindView(R.id.iv_article3)
    ImageView iv_article3;
    @BindView(R.id.iv_article4)
    ImageView iv_article4;
    @BindView(R.id.iv_article5)
    ImageView iv_article5;
    @BindView(R.id.iv_article6)
    ImageView iv_article6;
    private View view;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, inflater.inflate(R.layout.fragment_community_child3, container, false));
        return inflater.inflate(R.layout.fragment_community_child3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initView();
    }

    private void initView() {
/*        specialistList = TestData.getSpecialistData();
        rv_community_child3.setLayoutManager(new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rv_community_child3.setItemAnimator(new ScaleInAnimator());
        rv_community_child3.setHasFixedSize(true);

        SpecialistRecyclerViewAdapter specialistRecyclerViewAdapter = new SpecialistRecyclerViewAdapter(getContext(), specialistList);
        specialistRecyclerViewAdapter.setOnItemClickListener(new SpecialistRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(getContext(), SpecialistActivity.class));
            }
        });
        rv_community_child3.setAdapter(specialistRecyclerViewAdapter);*/

        Glide.with(this).load(R.mipmap.article1).into(iv_article1);
        Glide.with(this).load(R.mipmap.article2).into(iv_article2);
        Glide.with(this).load(R.mipmap.article3).into(iv_article3);
        Glide.with(this).load(R.mipmap.article4).into(iv_article4);
        Glide.with(this).load(R.mipmap.article5).into(iv_article5);
        Glide.with(this).load(R.mipmap.article6).into(iv_article6);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_article4, R.id.iv_article5, R.id.iv_article6})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }
}
