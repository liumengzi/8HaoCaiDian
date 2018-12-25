package com.tuding.client.eightnumcolour.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.tuding.client.eightnumcolour.R;

public class InitPayPsActivity extends RBBaseActivity {

    private EditText password_et;
    private EditText confirm_password_et;
    private Button init_paypassword_bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_payps);
        initUI();
        initValue();
    }



    @Override
    public void initUI() {
        password_et = findViewById(R.id.password_et);
        confirm_password_et = findViewById(R.id.confirm_password_et);

        init_paypassword_bt = findViewById(R.id.init_paypassword_bt);
        init_paypassword_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yanzheng()) {


                }
            }
        });
    }

    private void request (){

    }

    String password,confirm_password;
    private boolean yanzheng(){
        password = password_et.getText().toString().replaceAll(" ", "");
        confirm_password = confirm_password_et.getText().toString().replaceAll(" ", "");

        if (password.equals("")) {
            Toast.makeText(InitPayPsActivity.this,"信息输入不完整！",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (confirm_password.equals("")) {
            Toast.makeText(InitPayPsActivity.this,"信息输入不完整！",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!password.equals(confirm_password)) {
            Toast.makeText(InitPayPsActivity.this,"两次输入密码不一致！",Toast.LENGTH_SHORT).show();

            return false;
        }
        return true;
    }

    @Override
    public void initValue() {
    }
}
