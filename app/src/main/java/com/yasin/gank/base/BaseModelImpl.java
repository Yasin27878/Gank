package com.yasin.gank.base;

import com.google.gson.Gson;
import com.yasin.gank.core.GankApplication;
import com.yasin.gank.helper.SpfHelper;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description :Model实现类
 */

public class BaseModelImpl implements BaseModel {
    //GankApplication实例
    protected GankApplication mApplication;
    // Gson实例
    protected Gson mGson;
    //SpfHelper实例
    protected SpfHelper mSpfHelper;

    public BaseModelImpl() {
        mApplication = GankApplication.mInstance;
        mSpfHelper = mApplication.getSpfHelper();
        mGson = mApplication.getGson();
    }
}
