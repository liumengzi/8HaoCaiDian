package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuding.client.eightnumcolour.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RetrievePasswordActivity extends RBBaseActivity {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.et_nickname)
    EditText etNickname;
    @Bind(R.id.icon_yan)
    ImageView iconYan;
    @Bind(R.id.et_sms)
    EditText etSms;
    @Bind(R.id.tv_get_smscode)
    TextView tvGetSmscode;
    @Bind(R.id.et_ps)
    EditText etPs;
    @Bind(R.id.et_second_ps)
    EditText etSecondPs;
    @Bind(R.id.tv_next)
    TextView tvNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetps);
        ButterKnife.bind(this);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initValue() {
    }
}
