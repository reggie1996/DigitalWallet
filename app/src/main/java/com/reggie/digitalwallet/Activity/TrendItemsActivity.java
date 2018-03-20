package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gc.materialdesign.views.Switch;
import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TrendItemsActivity extends Activity {

    protected ImmersionBar mImmersionBar;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.switchView1)
    Switch switchView1;
    @BindView(R.id.switchView2)
    Switch switchView2;
    @BindView(R.id.switchView3)
    Switch switchView3;
    @BindView(R.id.switchView4)
    Switch switchView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend_items);
        ButterKnife.bind(this);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.barColor(R.color.colorGold1).statusBarDarkFont(false).init();

        switchView1.setChecked(true);
        switchView2.setChecked(true);
        switchView3.setChecked(true);
        switchView4.setChecked(true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }

    @OnClick(R.id.back)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
