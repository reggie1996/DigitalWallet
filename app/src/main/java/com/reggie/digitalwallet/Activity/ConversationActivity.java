package com.reggie.digitalwallet.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConversationActivity extends Activity {

    @BindView(R.id.et_message)
    EditText et_message;
    @BindView(R.id.tv_send)
    TextView tv_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        ButterKnife.bind(this);

        tv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"发送",Toast.LENGTH_LONG).show();
            }
        });
    }
}
