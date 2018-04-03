package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BackupNextActivity extends Activity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.textView23)
    TextView textView23;
    @BindView(R.id.textView24)
    TextView textView24;
    @BindView(R.id.textView25)
    TextView textView25;
    @BindView(R.id.textView26)
    TextView textView26;
    @BindView(R.id.textView27)
    TextView textView27;
    @BindView(R.id.textView28)
    TextView textView28;
    @BindView(R.id.textView29)
    TextView textView29;
    @BindView(R.id.textView30)
    TextView textView30;
    @BindView(R.id.textView31)
    TextView textView31;
    @BindView(R.id.textView32)
    TextView textView32;
    @BindView(R.id.textView33)
    TextView textView33;
    @BindView(R.id.textView34)
    TextView textView34;
    @BindView(R.id.setup)
    TextView setup;
    @BindView(R.id.critic)
    TextView critic;
    @BindView(R.id.notable)
    TextView notable;
    @BindView(R.id.duty)
    TextView duty;
    @BindView(R.id.tomato)
    TextView tomato;
    @BindView(R.id.work)
    TextView work;
    @BindView(R.id.curve)
    TextView curve;
    @BindView(R.id.theory)
    TextView theory;
    @BindView(R.id.expand)
    TextView expand;
    @BindView(R.id.jealous)
    TextView jealous;
    @BindView(R.id.country)
    TextView country;
    @BindView(R.id.live)
    TextView live;
    @BindView(R.id.bt_next)
    Button bt_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_next);
        ButterKnife.bind(this);

        //状态栏修改
        ImmersionBar.with(this)
                .statusBarDarkFont(false)//状态栏字体是深色，不写默认为亮色
                .fitsSystemWindows(true)
                .statusBarColor(R.color.colorGold1)
                .init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.country,R.id.back, R.id.setup, R.id.critic, R.id.notable, R.id.duty, R.id.tomato, R.id.work, R.id.curve, R.id.theory, R.id.expand, R.id.jealous, R.id.live, R.id.bt_next})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.setup:
                textView33.setVisibility(View.VISIBLE);
                setup.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                setup.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.critic:
                textView27.setVisibility(View.VISIBLE);
                critic.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                critic.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.country:
                textView28.setVisibility(View.VISIBLE);
                country.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                country.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.notable:
                textView23.setVisibility(View.VISIBLE);
                notable.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                notable.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.duty:
                textView29.setVisibility(View.VISIBLE);
                duty.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                duty.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.tomato:
                textView31.setVisibility(View.VISIBLE);
                tomato.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                tomato.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.work:
                textView26.setVisibility(View.VISIBLE);
                work.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                work.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.curve:
                textView25.setVisibility(View.VISIBLE);
                curve.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                curve.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.theory:
                textView34.setVisibility(View.VISIBLE);
                theory.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                theory.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.expand:
                textView30.setVisibility(View.VISIBLE);
                expand.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                expand.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.jealous:
                textView24.setVisibility(View.VISIBLE);
                jealous.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                jealous.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.live:
                textView32.setVisibility(View.VISIBLE);
                live.setBackgroundColor(getResources().getColor(R.color.colorGold2));
                live.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.bt_next:
                Toast.makeText(this,"认证通过!",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
