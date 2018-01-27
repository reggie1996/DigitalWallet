package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Test.TestData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SendActivity extends Activity {

    protected ImmersionBar mImmersionBar;
    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.iv_scan)
    ImageView iv_scan;
    @BindView(R.id.bt_send)
    Button bt_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        ButterKnife.bind(this);
        mImmersionBar.with(this).transparentBar().statusBarDarkFont(true).init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }

    @OnClick({R.id.iv_back, R.id.iv_scan, R.id.bt_send})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_scan:
                startActivityForResult(new Intent(getApplicationContext(),QRCodeActivity.class),1);
                break;
            case R.id.bt_send:
                send();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this,"扫描成功",Toast.LENGTH_LONG).show();

    }

    private void send(){
        Toast.makeText(this,"发送",Toast.LENGTH_LONG).show();
    }
}
