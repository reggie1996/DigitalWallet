package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConversationActivity extends Activity {

    @BindView(R.id.et_message)
    EditText et_message;
    @BindView(R.id.tv_send)
    TextView tv_send;

    protected ImmersionBar mImmersionBar;
    @BindView(R.id.ll_first)
    LinearLayout ll_first;
    @BindView(R.id.ll_sec)
    LinearLayout ll_sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        ButterKnife.bind(this);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.keyboardEnable(true).barColor(R.color.colorGold1).statusBarDarkFont(false).init();

        tv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_message.setText("");
                ll_first.setVisibility(View.VISIBLE);
            }
        });
        tv_send.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ll_sec.setVisibility(View.VISIBLE);
                return true;
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }
}
