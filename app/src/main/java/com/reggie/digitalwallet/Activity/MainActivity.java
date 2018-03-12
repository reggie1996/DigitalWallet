package com.reggie.digitalwallet.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.Fragment.BaseFragment;
import com.reggie.digitalwallet.Fragment.CommunityFragment;
import com.reggie.digitalwallet.Fragment.MallFragment;
import com.reggie.digitalwallet.Fragment.TrendFragment;
import com.reggie.digitalwallet.Fragment.WalletFragment;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Utils.WalletUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class MainActivity extends FragmentActivity {


    @BindView(R.id.iv_bg)
    ImageView mIvBg;
    @BindView(R.id.iv_qrcode)
    ImageView iv_qrcode;
    @BindView(R.id.ll_menu_import_wallet)
    LinearLayout ll_menu_import_wallet;
    @BindView(R.id.ll_menu_create_wallet)
    LinearLayout ll_menu_create_wallet;
    @BindView(R.id.ll_menu_wallet_manage)
    LinearLayout ll_menu_wallet_manage;
    @BindView(R.id.ll_menu_personal_fortune)
    LinearLayout ll_menu_personal_fortune;
    @BindView(R.id.ll_menu_message_center)
    LinearLayout ll_menu_message_center;
    @BindView(R.id.ll_menu_contacts)
    LinearLayout ll_menu_contacts;
    @BindView(R.id.ll_menu_customer_service)
    LinearLayout ll_menu_customer_service;
    @BindView(R.id.ll_menu_help)
    LinearLayout ll_menu_help;
    @BindView(R.id.ll_menu_account_manage)
    LinearLayout ll_menu_account_manage;
    @BindView(R.id.ll_menu_system_manage)
    LinearLayout ll_menu_system_manage;
    @BindView(R.id.ll_menu_exit)
    LinearLayout ll_menu_exit;

    private RadioGroup radioGroup;
    private List<BaseFragment> mBaseFragments;
    private int position;
    private Fragment mContent;


    protected ImmersionBar mImmersionBar;

    DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();

        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();
        initDrawer();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }


    private void initView() {
        drawer = findViewById(R.id.drawer);
        radioGroup = findViewById(R.id.rg_bottom_tag);
    }

    private void initFragment() {
        mBaseFragments = new ArrayList<>();
        mBaseFragments.add(new WalletFragment());
        mBaseFragments.add(new TrendFragment());
        mBaseFragments.add(new CommunityFragment());
        mBaseFragments.add(new MallFragment());
    }

    private void initDrawer() {
        Glide.with(this).load(R.mipmap.bg2).apply(bitmapTransform(new BlurTransformation(10))).into(mIvBg);
    }

    //------------------------设置底部的按钮------------------
    private void setListener() {
        radioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        radioGroup.check(R.id.rb_wallet);
    }

    @OnClick({R.id.iv_qrcode, R.id.ll_menu_import_wallet, R.id.ll_menu_create_wallet, R.id.ll_menu_wallet_manage, R.id.ll_menu_personal_fortune, R.id.ll_menu_message_center, R.id.ll_menu_contacts, R.id.ll_menu_customer_service, R.id.ll_menu_help, R.id.ll_menu_account_manage, R.id.ll_menu_system_manage, R.id.ll_menu_exit, R.id.navigation_view})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_qrcode:
                Toast.makeText(this,"二维码",Toast.LENGTH_LONG).show();
                break;
            case R.id.ll_menu_import_wallet:
                WalletUtils.importWallet(this);
                drawer.closeDrawers();
                break;
            case R.id.ll_menu_create_wallet:
                WalletUtils.generateWallet(this);
                drawer.closeDrawers();
                break;
            case R.id.ll_menu_wallet_manage:
                break;
            case R.id.ll_menu_personal_fortune:
                break;
            case R.id.ll_menu_message_center:
                break;
            case R.id.ll_menu_contacts:
                break;
            case R.id.ll_menu_customer_service:
                break;
            case R.id.ll_menu_help:
                break;
            case R.id.ll_menu_account_manage:
                break;
            case R.id.ll_menu_system_manage:
                break;
            case R.id.ll_menu_exit:
                Toast.makeText(this,"退出",Toast.LENGTH_LONG).show();
                break;
            case R.id.navigation_view:
                break;
        }
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_wallet:
                    mImmersionBar.barColor(R.color.colorGold2).statusBarDarkFont(false).init();
                    position = 0;
                    break;
                case R.id.rb_trend:
                    mImmersionBar.transparentBar().statusBarDarkFont(false).init();
                    position = 1;
                    break;
                case R.id.rb_community:
                    mImmersionBar.transparentBar().statusBarDarkFont(true).init();
                    position = 2;
                    break;
                case R.id.rb_mall:
                    mImmersionBar.barColor(R.color.colorGold2).statusBarDarkFont(false).init();
                    position = 3;
                    break;
                default:
                    mImmersionBar.transparentBar().statusBarDarkFont(true).init();
                    position = 0;
                    break;
            }

            //根据位置对应的Fragment
            BaseFragment to = getFragment();
            //替换
            switchFragment(mContent, to);
        }
    }

    //from 原先是，to后来的fragment
    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //判断有没有被添加
            if (!to.isAdded()) {
                //to没有被添加 from隐藏 添加to
                if (from != null) {
                    ft.hide(from);
                }
                if (to != null) {
                    ft.add(R.id.fl_content, to).commit();
                }
            } else {
                //to已经被添加 from隐藏 显示to
                if (from != null) {
                    ft.hide(from);
                }
                if (to != null) {
                    ft.show(to).commit();
                }
            }
        }
    }

    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragments.get(position);
        return fragment;
    }


}
