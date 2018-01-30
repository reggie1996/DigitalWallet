package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Utils.QRCodeGenerator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReciveActivity extends Activity {

    protected ImmersionBar mImmersionBar;
    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.et_recive_num)
    EditText et_recive_num;
    @BindView(R.id.iv_qrcode)
    ImageView iv_qrcode;
    @BindView(R.id.spinner_recive_name)
    Spinner spinner_recive_name;

    private String account;
    private String amount = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive);
        ButterKnife.bind(this);

        mImmersionBar.with(this).transparentBar().statusBarDarkFont(true).init();

        et_recive_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                amount = charSequence.toString();

                String message = "qr://transfer?to=" + account +"&amount=" + amount;
                Bitmap qrcode = QRCodeGenerator.createQRCode(message);
                Glide.with(getApplicationContext())
                        .load(qrcode)
                        .into(iv_qrcode);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });


        final String[] wallets = {"batman111", "superman111", "flash111", "aquaman111"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, wallets);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_recive_name.setAdapter(adapter);
        spinner_recive_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                account = wallets[i];
                String message = "qr://transfer?to=" + account +"&amount=" + amount;
                Bitmap qrcode = QRCodeGenerator.createQRCode(message);
                Glide.with(getApplicationContext())
                        .load(qrcode)
                        .into(iv_qrcode);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }


    @OnClick(R.id.iv_back)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
