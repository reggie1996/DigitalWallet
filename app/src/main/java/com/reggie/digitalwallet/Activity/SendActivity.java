package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SendActivity extends Activity {

    private static final int REQUSTCODE_SCAN_QRCODE = 1;

    protected ImmersionBar mImmersionBar;
    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.iv_scan)
    ImageView iv_scan;
    @BindView(R.id.bt_send)
    Button bt_send;
    @BindView(R.id.spinner_send_from)
    Spinner spinner_send_from;
    @BindView(R.id.iv_send_from)
    ImageView iv_send_from;
    @BindView(R.id.iv_send_to)
    ImageView iv_send_to;
    @BindView(R.id.et_send_to)
    EditText et_send_to;
    @BindView(R.id.spinner_send_to)
    Spinner spinner_send_to;
    @BindView(R.id.et_amount)
    EditText et_amount;

    String to_name;
    String amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        ButterKnife.bind(this);
        mImmersionBar.with(this).transparentBar().statusBarDarkFont(true).init();

        initSendFrom();
        initSendTo();
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
                startActivityForResult(new Intent(getApplicationContext(), QRCodeActivity.class), REQUSTCODE_SCAN_QRCODE);
                break;
            case R.id.bt_send:
                send();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUSTCODE_SCAN_QRCODE:
                if (resultCode == 1) {
                    String result = data.getStringExtra("result");

                    Uri uri = Uri.parse(result);
                    to_name = uri.getQueryParameter("to");
                    amount = uri.getQueryParameter("amount");

                    et_send_to.setText(to_name);
                    et_amount.setText(amount);

                }
        }
        Toast.makeText(this, "扫描成功", Toast.LENGTH_LONG).show();

    }


    private void initSendFrom() {
        final String[] wallets = {"batman111", "superman111", "flash111", "aquaman111"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, wallets);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_send_from.setAdapter(adapter);
        spinner_send_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), wallets[i] + "选中", Toast.LENGTH_LONG).show();
                String url = "http://block.gxb.io/api/header/" + wallets[i];
                Glide.with(getApplicationContext()).load(url).into(iv_send_from);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initSendTo() {
        et_send_to.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String url = "http://block.gxb.io/api/header/" + charSequence;
                Glide.with(getApplicationContext()).load(url).into(iv_send_to);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        final String[] coins = {"GXS", "BTS", "AAA", "BBB"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, coins);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_send_to.setAdapter(adapter);
        spinner_send_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void send() {
        Toast.makeText(this, "发送", Toast.LENGTH_LONG).show();
    }
}
