package com.reggie.digitalwallet.Activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.Fragment.BaseFragment;
import com.reggie.digitalwallet.Fragment.CommunityFragment;
import com.reggie.digitalwallet.Fragment.MallFragment;
import com.reggie.digitalwallet.Fragment.TrendFragment;
import com.reggie.digitalwallet.Fragment.WalletFragment;
import com.reggie.digitalwallet.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup radioGroup;
    private List<BaseFragment> mBaseFragments;
    private int position;
    private android.support.v4.app.Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImmersionBar.with(this)
                .statusBarDarkFont(true)//状态栏字体是深色，不写默认为亮色
                .init();

        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
    }

    //------------------------设置底部的按钮------------------
    private void setListener() {
        radioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        radioGroup.check(R.id.rb_wallet);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_wallet:
                    position = 0;
                    break;
                case R.id.rb_trend:
                    position = 1;
                    break;
                case R.id.rb_community:
                    position = 2;
                    break;
                case R.id.rb_mall:
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }

            //根据位置对应的Fragment
            BaseFragment to = getFragment();
            //替换
            switchFragment(mContent,to);
        }
    }
    //from 原先是，to后来的fragment
    private void switchFragment(android.support.v4.app.Fragment from, android.support.v4.app.Fragment to) {
        if(from != to){
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //判断有没有被添加
            if(!to.isAdded()){
                //to没有被添加 from隐藏 添加to
                if (from != null){
                    ft.hide(from);
                }
                if(to != null){
                    ft.add(R.id.fl_content,to).commit();
                }
            }else {
                //to已经被添加 from隐藏 显示to
                if (from != null){
                    ft.hide(from);
                }
                if(to != null){
                    ft.show(to).commit();
                }
            }
        }
    }

    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragments.get(position);
        return fragment;
    }

    private void initView(){
        radioGroup = findViewById(R.id.rg_bottom_tag);
    }
    private void initFragment(){
        mBaseFragments = new ArrayList<>();
        mBaseFragments.add(new WalletFragment());
        mBaseFragments.add(new TrendFragment());
        mBaseFragments.add(new CommunityFragment());
        mBaseFragments.add(new MallFragment());
    }

}
