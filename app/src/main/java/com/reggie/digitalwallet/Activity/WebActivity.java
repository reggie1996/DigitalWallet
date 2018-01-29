package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.ChromeClientCallbackManager;
import com.just.agentweb.DefaultWebClient;
import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebActivity extends Activity {

    protected AgentWeb mAgentWeb;
    @BindView(R.id.mLinearLayout)
    LinearLayout mLinearLayout;
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.bt_exit)
    ImageButton bt_exit;

    String webUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        webUrl = intent.getStringExtra("webUrl");

        //状态栏修改
        ImmersionBar.with(this)
                .statusBarDarkFont(false)//状态栏字体是深色，不写默认为亮色
                .fitsSystemWindows(true)
                .statusBarColor(R.color.colorGold1)
                .init();

        mAgentWeb = AgentWeb.with(this)//
                .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))//
                .useDefaultIndicator()//
                .defaultProgressBarColor()
//                .setIndicatorColorWithHeight(-1, 3)
                .setReceivedTitleCallback(mCallback)
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setSecurityType(AgentWeb.SecurityType.strict)
                //.setWebLayout(new WebLayout(this))
                .openParallelDownload()//打开并行下载 , 默认串行下载
                .setNotifyIcon(R.drawable.ic_file_download_black_24dp) //下载图标
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
                .interceptUnkownScheme() //拦截找不到相关页面的Scheme
                .createAgentWeb()//
                .ready()
                .go(webUrl);
        //Toast.makeText(this,webUrl,Toast.LENGTH_LONG).show();
    }



    private ChromeClientCallbackManager.ReceivedTitleCallback mCallback = new ChromeClientCallbackManager.ReceivedTitleCallback() {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            if (toolbar_title != null)
                toolbar_title.setText(title);
        }
    };

    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
//            Log.i("Info","progress:"+newProgress);
        }
    };

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    };

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAgentWeb.getWebLifeCycle().onDestroy();
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
    }


    @OnClick(R.id.bt_exit)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_exit:
                finish();
                break;
        }
    }
}