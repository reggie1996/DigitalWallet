package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;
import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderGoodsActivity extends Activity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.button)
    ButtonRectangle button;

    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_goods);
        ButterKnife.bind(this);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.barColor(R.color.colorGold1).statusBarDarkFont(false).init();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }


    @OnClick({R.id.back, R.id.button})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.button:
                Toast.makeText(this,"下单成功,转向支付界面",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,Send2Activity.class));
                break;
        }
    }
}
