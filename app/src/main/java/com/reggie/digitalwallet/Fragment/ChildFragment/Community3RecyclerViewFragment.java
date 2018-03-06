package com.reggie.digitalwallet.Fragment.ChildFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reggie.digitalwallet.Activity.SpecialistActivity;
import com.reggie.digitalwallet.Adapter.SpecialistRecyclerViewAdapter;
import com.reggie.digitalwallet.Model.Specialist;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Test.TestData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;

/**
 * A simple {@link Fragment} subclass.
 */
public class Community3RecyclerViewFragment extends Fragment {

    @BindView(R.id.rv_community_child3)
    RecyclerView rv_community_child3;
    List<Specialist> specialistList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_community_child3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initView();
    }

    private void initView(){
        specialistList = TestData.getSpecialistData();
        rv_community_child3.setLayoutManager(new LinearLayoutManager(getActivity()){
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
        rv_community_child3.setAdapter(specialistRecyclerViewAdapter);

    }
}
