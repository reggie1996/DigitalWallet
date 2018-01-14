package com.reggie.digitalwallet.Test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.reggie.digitalwallet.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SFZActivity extends Activity {

    @BindView(R.id.button2)
    Button bt_start;
    @BindView(R.id.tv_result)
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfz);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button2)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button2:
                post();
                break;
        }
    }

    void post(){
        String url = "https://api-cn.faceplusplus.com/cardpp/v1/ocridcard";
        String api_key = "e3hykz0ogOm82VknRV0PfoAXAOiu724l";
        String api_secret = "bKYqcHXvLM0TUDhSa1-zqC70ujFFqOkg";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("api_key",api_key)
                .add("api_secret",api_secret)
                .add("image_url","http://n1.itc.cn/img8/wb/recom/2016/08/11/147087795158272588.JPEG").build();
        final Request request = new Request.Builder()
                .post(body)
                .url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            tv_result.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });


    }


}
