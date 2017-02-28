package com.yasin.gank.core;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description : Gank的Application
 */

public class GankApplication extends Application {
    public static GankApplication mInstance;
    public static ApiManager.ApiService mService;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        Stetho.initializeWithDefaults(mInstance);

        initService();

    }

    /**
     * 初始化网络接口服务
     */
    private void initService() {
        if (mService == null) {
            synchronized (GankApplication.class) {
                mService = ApiManager.getInstance().getService(ApiManager.ApiService.class);
            }
        }

    }
}
