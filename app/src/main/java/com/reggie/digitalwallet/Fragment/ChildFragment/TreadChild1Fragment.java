package com.reggie.digitalwallet.Fragment.ChildFragment;


import android.support.v4.app.Fragment;

import com.reggie.digitalwallet.Fragment.BaseLazyFragment;
import com.reggie.digitalwallet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TreadChild1Fragment extends BaseLazyFragment {

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_tread_child1;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarDarkFont(true, 0.2f)
                .navigationBarColor(R.color.colorGold1)
                .init();
    }

}
