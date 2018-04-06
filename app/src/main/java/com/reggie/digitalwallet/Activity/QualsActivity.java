package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.Adapter.QualsPagerAdapter;
import com.reggie.digitalwallet.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 区块链资格测试
 */
public class QualsActivity extends Activity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.previous)
    TextView previous;
    @BindView(R.id.next)
    TextView next;
    @BindView(R.id.bt_finish)
    Button bt_finish;

    private ArrayList<View> qList;
    QualsPagerAdapter qualsPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quals);
        ButterKnife.bind(this);

        //状态栏修改
        ImmersionBar.with(this)
                .statusBarDarkFont(false)//状态栏字体是深色，不写默认为亮色
                .fitsSystemWindows(true)
                .statusBarColor(R.color.colorGold2)
                .init();

        qList = new ArrayList<>();
        qList.add(getLayoutInflater().inflate(R.layout.item_q1, null, false));
        qList.add(getLayoutInflater().inflate(R.layout.item_q2, null, false));
        qList.add(getLayoutInflater().inflate(R.layout.item_q3, null, false));
        qList.add(getLayoutInflater().inflate(R.layout.item_q4, null, false));
        qList.add(getLayoutInflater().inflate(R.layout.item_q5, null, false));
        qList.add(getLayoutInflater().inflate(R.layout.item_q8, null, false));
        qList.add(getLayoutInflater().inflate(R.layout.item_q6, null, false));
        qList.add(getLayoutInflater().inflate(R.layout.item_q7, null, false));
        qualsPagerAdapter = new QualsPagerAdapter(qList);
        viewpager.setAdapter(qualsPagerAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @OnClick({R.id.previous, R.id.next, R.id.bt_finish})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.previous:
                viewpager.arrowScroll(View.FOCUS_LEFT);
                break;
            case R.id.next:
                viewpager.arrowScroll(View.FOCUS_RIGHT);
                break;
            case R.id.bt_finish:
                new MaterialDialog.Builder(this)
                        .title("测评结果")
                        .content("正确率：100% \n已解锁钱包功能！")
                        .positiveText("确认")
                        .show();
                break;
        }
    }
}
