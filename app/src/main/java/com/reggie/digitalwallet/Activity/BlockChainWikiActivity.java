package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;

public class BlockChainWikiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_chain_wiki);

        //状态栏修改
        ImmersionBar.with(this)
                .statusBarDarkFont(false)//状态栏字体是深色，不写默认为亮色
                .fitsSystemWindows(true)
                .statusBarColor(R.color.colorGold2)
                .init();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
