package com.reggie.digitalwallet.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.reggie.digitalwallet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallFragment extends BaseFragment {


    ImageView iv_mall1;
    ImageView iv_mall2;
    ImageView iv_mall3;
    ImageView iv_store1;
    ImageView iv_store2;
    ImageView iv_store3;
    ImageView iv_store4;
    ImageView iv_store5;
    private View view;

    @Override
    protected View initView() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mall, container, false);
        initImage();
        return view;
    }

    private void initImage() {
        iv_mall1 = view.findViewById(R.id.iv_mall1);
        iv_mall2 = view.findViewById(R.id.iv_mall2);
        iv_mall3 = view.findViewById(R.id.iv_mall3);
        iv_store1 = view.findViewById(R.id.iv_store1);
        iv_store2 = view.findViewById(R.id.iv_store2);
        iv_store3 = view.findViewById(R.id.iv_store3);
        iv_store4 = view.findViewById(R.id.iv_store4);
        iv_store5 = view.findViewById(R.id.iv_store5);
        Glide.with(this).load(R.mipmap.mall1).into(iv_mall1);
        Glide.with(this).load(R.mipmap.mall2).into(iv_mall2);
        Glide.with(this).load(R.mipmap.mall3).into(iv_mall3);
        Glide.with(this).load(R.mipmap.store1).into(iv_store1);
        Glide.with(this).load(R.mipmap.store2).into(iv_store2);
        Glide.with(this).load(R.mipmap.store3).into(iv_store3);
        Glide.with(this).load(R.mipmap.store4).into(iv_store4);
        Glide.with(this).load(R.mipmap.store5).into(iv_store5);

        iv_mall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
