package com.tuding.client.eightnumcolour.application;

import android.content.Context;
import android.os.Handler;

import com.lzy.okgo.OkGo;

import org.litepal.LitePalApplication;

/**
 * Application
 *
 * @author wtz
 */
public class RBBaseApplication extends LitePalApplication {
    private static final String TAG = "RBBaseApplication";
    public static String token = "123";
    public static String regId = "";
    private static RBBaseApplication instance;
    public Handler mHandler;
    public static RBBaseApplication getInstance() {
        return instance;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().debug("OKGO").init(this);
       /* WXPay.init(this, "wxaa9bd6597c1f57ae");
        OkGo.getInstance().debug("OKGO").init(this);

        RPSDK.initialize(this);

        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPush
        //建议添加tag标签，发送消息的之后就可以指定tag标签来发送了
        Set<String> set = new HashSet<>();
        set.add("All_ALL");//名字任意，可多添加几个*/
        instance = this;
        mHandler = new Handler();

    }


    @Override
    public void onTerminate() {
        super.onTerminate();


        mHandler = null;
        instance = null;
    }


}
