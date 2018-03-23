package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WriteMomentActivity extends Activity {


    @BindView(R.id.tv_back)
    TextView tv_back;
    @BindView(R.id.editText)
    EditText mEditText;
    @BindView(R.id.tv_publish)
    TextView tv_publish;

    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_moment);
        ButterKnife.bind(this);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.keyboardEnable(true).barColor(R.color.colorGold1).statusBarDarkFont(false).init();

    }

    @OnClick({R.id.tv_back, R.id.tv_publish})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_publish:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }


}
