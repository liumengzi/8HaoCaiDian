package com.tuding.client.eightnumcolour.utls;

import android.widget.Toast;

import com.tuding.client.eightnumcolour.application.RBBaseApplication;

public class ToastUtil {

    /**
     * 系统Toast
     */
    public static void showToast(final String text) {
        RBBaseApplication.getInstance().mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RBBaseApplication.getInstance(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 系统Toast
     */
    public static void showToast(final int textId) {
        RBBaseApplication.getInstance().mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RBBaseApplication.getInstance(), RBBaseApplication.getInstance().getString(textId), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
