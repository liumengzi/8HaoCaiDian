package com.tuding.client.eightnumcolour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tuding.client.eightnumcolour.R;
import com.tuding.client.eightnumcolour.utls.URls;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class ModifyLoginPsActivity extends RBBaseActivity {

    private EditText update_old_password_et;
    private EditText update_new_password_et;
    private EditText update_new_passwordqueren_et;
    private Button update_loginpassword_confirm_bt;
    private String old;
    private String news;
    private String queren;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_loginps);
        initUI();
        initValue();
    }

    @Override
    public void initUI() {

        update_old_password_et = findViewById(R.id.update_old_password_et);
        update_new_password_et = findViewById(R.id.update_new_password_et);
        update_new_passwordqueren_et = findViewById(R.id.update_new_passwordqueren_et);

        update_loginpassword_confirm_bt = findViewById(R.id.update_loginpassword_confirm_bt);
        update_loginpassword_confirm_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yanzheng()) {
                    request();

                }

            }
        });
    }

    private void request(){
        OkGo.post(URls.MODIFY_PASS)
             .tag(this)
             .params("oldpass",old)
             .params("password",news)
                .params("confirm_pass",queren)
             .execute(new StringCallback() {
                 @Override
                 public void onSuccess(String s, Call call, Response response) {

                     try {

                         JSONObject jsonObject = new JSONObject(s);
                         if (jsonObject.getInt("code") != 1) {

                             Toast.makeText(ModifyLoginPsActivity.this,jsonObject.getString("msg"),Toast.LENGTH_SHORT).show();
//                             return;
                         }

                         Toast.makeText(ModifyLoginPsActivity.this,jsonObject.getString("msg"),Toast.LENGTH_SHORT).show();

                         startActivity(new Intent(ModifyLoginPsActivity.this,LoginActivity.class));
                         finish();

                     } catch (JSONException e) {
                         e.printStackTrace();
                     }

                 }
             });
    }
    private boolean yanzheng(){
        old = update_old_password_et.getText().toString().replaceAll(" ", "");
        news = update_new_password_et.getText().toString().replaceAll(" ", "");
        queren = update_new_passwordqueren_et.getText().toString().replaceAll(" ", "");

        if (old.equals("")) {
            Toast.makeText(ModifyLoginPsActivity.this,"信息输入不完整！",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (news.equals("")) {
            Toast.makeText(ModifyLoginPsActivity.this,"信息输入不完整！",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (queren.equals("")) {
            Toast.makeText(ModifyLoginPsActivity.this,"信息输入不完整！",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!news.equals(queren)) {
            Toast.makeText(ModifyLoginPsActivity.this,"确认密码不一致！",Toast.LENGTH_SHORT).show();

            return false;
        }
        return true;
    }
    @Override
    public void initValue() {
    }
}
