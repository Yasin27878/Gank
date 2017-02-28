package com.yasin.gank.core;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yasin.gank.helper.SpfHelper;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description : Gank的Application
 */

public class GankApplication extends Application {
    public static GankApplication mInstance;
    public static ApiManager.ApiService mService;
    public static Gson mGson;

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
    /**
     * SpfHelper 单例
     *
     * @return
     */
    public SpfHelper getSpfHelper() {
        return SpfHelper.getInstance(this, ConstantApp.SP_NAME);
    }
    /**
     * Gson 单例
     *
     * @return
     */
    public Gson getGson() {
        if (mGson == null) {
            synchronized (Gson.class) {
                if (mGson == null) {
                    mGson = new GsonBuilder()
                            //.registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory())
                            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                            .create();
                }
            }
        }
        return mGson;
    }
}
