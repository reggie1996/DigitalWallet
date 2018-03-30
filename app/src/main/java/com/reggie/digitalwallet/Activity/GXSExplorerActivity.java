package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.reggie.digitalwallet.R;

public class GXSExplorerActivity extends Activity {

    protected ImmersionBar mImmersionBar;
    private CollapsingToolbarLayout collapsingToolbar;
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gxsexplorer);

        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("区块链浏览器");

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.barColor(R.color.colorGold2).statusBarDarkFont(false).init();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }
}
