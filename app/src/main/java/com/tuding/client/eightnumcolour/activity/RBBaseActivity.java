package com.tuding.client.eightnumcolour.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.tuding.client.eightnumcolour.application.RBBaseApplication;
import com.tuding.client.eightnumcolour.view.LoadingDialog;

import java.lang.reflect.Field;

/*
 * @Description: 基础Activity
 */
public abstract class RBBaseActivity extends AppCompatActivity {
    private static final String TAG = "RBBaseActivity";
    protected Context mContext;
    protected RBBaseApplication app;
    protected boolean setStatusBar = false;//是否设置状态栏颜色
    protected LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingDialog = new LoadingDialog(this);
        mContext = this;
        app = (RBBaseApplication) getApplication();
    }

    /**
     * 7.0（含）以上的系统，状态栏修改为透明色无效 时执行
     */
    public void statusBarColor70() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                Class decorViewClazz = Class.forName("com.android.internal.policy.DecorView");
                Field field = decorViewClazz.getDeclaredField("mSemiTransparentStatusBarColor");
                field.setAccessible(true);
                field.setInt(getWindow().getDecorView(), Color.TRANSPARENT);  //改为透明
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public abstract void initUI();

    public abstract void initValue();

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    /**
     * 隐藏键盘
     */
    public void closeInputMethod() {
        View v = getCurrentFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context
                .INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(v != null ? v.getWindowToken() : null, 0);
        }
    }

    /**
     * 显示键盘
     */
    public void showInputMethod() throws NullPointerException {
        View v = getCurrentFocus();
        if (v == null) {
            throw new NullPointerException("focus view can not be null, please set a focus view");
        }
        InputMethodManager imm = (InputMethodManager) getSystemService(Context
                .INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(v, 0);
        }
    }

    @Override
    protected void onDestroy() {
        closeInputMethod();
        super.onDestroy();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
