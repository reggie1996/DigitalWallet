package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.lang.Thread.sleep;

public class GXSExplorerActivity extends Activity {

    Context mContext;

    protected ImmersionBar mImmersionBar;
    @BindView(R.id.et_info)
    EditText et_info;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.iv_logo)
    ImageView iv_logo;
    @BindView(R.id.ll_chain_info)
    LinearLayout ll_chain_info;
    private CollapsingToolbarLayout collapsingToolbar;

    OkHttpClient client = new OkHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gxsexplorer);
        ButterKnife.bind(this);

        mContext = this;

        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("区块链浏览器");

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.barColor(R.color.colorGold2).statusBarDarkFont(false).init();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }

    @OnClick(R.id.iv_search)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_search:
                search();
                break;
        }
    }

    private void search() {
        Editable text = et_info.getText();
        iv_logo.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        //Toast.makeText(this, text.toString(), Toast.LENGTH_LONG).show();

        String url = "http://block.gxb.io/api/block/" + text;

        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        //Toast.makeText(mContext, string, Toast.LENGTH_LONG).show();
                        ll_chain_info.setVisibility(View.VISIBLE);
                    }
                });

            }
        });


    }
}
