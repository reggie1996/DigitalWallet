package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.bumptech.glide.Glide;
import com.gc.materialdesign.views.ButtonFlat;
import com.gc.materialdesign.views.ButtonRectangle;
import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsActivity extends Activity implements DatePickerDialog.OnDateSetListener {

    @BindView(R.id.banner)
    Banner banner;
    List<String> bannerImages;

    protected ImmersionBar mImmersionBar;
    @BindView(R.id.tv_select_time)
    ButtonRectangle tv_select_time;
    @BindView(R.id.tv_start_year)
    TextView tv_start_year;
    @BindView(R.id.tv_start_month)
    TextView tv_start_month;
    @BindView(R.id.tv_start_day)
    TextView tv_start_day;
    @BindView(R.id.tv_end_year)
    TextView tv_end_year;
    @BindView(R.id.tv_end_month)
    TextView tv_end_month;
    @BindView(R.id.tv_end_day)
    TextView tv_end_day;
    @BindView(R.id.iv_detail)
    ImageView iv_detail;
    @BindView(R.id.iv_detail2)
    ImageView iv_detail2;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.bt_order)
    ButtonFlat bt_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ButterKnife.bind(this);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.barColor(R.color.colorGold1).statusBarDarkFont(false).init();

        bannerImages = new ArrayList();
        bannerImages.add("http://m.qpic.cn/psb?/V121cQJl2i1o9n/9Pm6fyfyvbih7uk90r5CP5102GEqGwlSDjnLXGYxebQ!/b/dFsBAAAAAAAA");
        bannerImages.add("http://m.qpic.cn/psb?/V121cQJl2i1o9n/ANk9sQ8l2zDcc4ggtfPUlzLMeD21tuD8IIdvs4Hdr4Y!/b/dEABAAAAAAAA");
        bannerImages.add("http://m.qpic.cn/psb?/V121cQJl2i1o9n/rfmwHCNock87gqfXf4huPXh0xN4phaxAzV.JOnKITeM!/b/dAgBAAAAAAAA");
        bannerImages.add("http://m.qpic.cn/psb?/V121cQJl2i1o9n/GepuRCUo*ZoIHi5InRNfIPXP6ycJ1qYtG*riRe9N6yI!/b/dEUBAAAAAAAA");
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        banner.setImages(bannerImages);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();

        Glide.with(this).load(R.mipmap.fly_detail).into(iv_detail);
        Glide.with(this).load(R.mipmap.fly_detail2).into(iv_detail2);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        //Toast.makeText(this,year + monthOfYear + dayOfMonth + "",Toast.LENGTH_LONG).show();
        tv_start_year.setText(year + "");
        tv_start_month.setText(monthOfYear + "");
        tv_start_day.setText(dayOfMonth + "");
        tv_end_year.setText(yearEnd + "");
        tv_end_month.setText(monthOfYearEnd + "");
        tv_end_day.setText(dayOfMonthEnd + "");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @OnClick({R.id.tv_select_time, R.id.tv_start_year, R.id.tv_start_month, R.id.tv_start_day, R.id.tv_end_year, R.id.tv_end_month, R.id.tv_end_day, R.id.back, R.id.bt_order})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_select_time:

                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        GoodsActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
                break;
            case R.id.back:
                finish();
                break;
            case R.id.bt_order:
                startActivity(new Intent(this,OrderGoodsActivity.class));
                break;
        }
    }
}
