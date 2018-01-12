package com.reggie.digitalwallet.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reggie.digitalwallet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false);
    }

    @Override
    protected View initView() {
        return null;
    }

    @Override
    protected void initData() {

    }

}
