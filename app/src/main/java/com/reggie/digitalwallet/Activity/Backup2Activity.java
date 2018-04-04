package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.lang.Thread.sleep;

public class Backup2Activity extends Activity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.bt_next)
    Button bt_next;
    @BindView(R.id.tv_words)
    TextView tv_words;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup2);
        ButterKnife.bind(this);

        //状态栏修改
        ImmersionBar.with(this)
                .statusBarDarkFont(false)//状态栏字体是深色，不写默认为亮色
                .fitsSystemWindows(true)
                .statusBarColor(R.color.colorGold1)
                .init();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            tv_words.setVisibility(View.VISIBLE);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.back, R.id.bt_next})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.bt_next:
                startActivity(new Intent(this, BackupNextActivity.class));
                break;
        }
    }
}
