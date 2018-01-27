package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReciveActivity extends Activity {

    protected ImmersionBar mImmersionBar;
    @BindView(R.id.iv_back)
    ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive);
        ButterKnife.bind(this);

        mImmersionBar.with(this).transparentBar().statusBarDarkFont(true).init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }


    @OnClick(R.id.iv_back)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
