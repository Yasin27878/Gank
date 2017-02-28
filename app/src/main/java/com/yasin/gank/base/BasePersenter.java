package com.yasin.gank.base;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description : Presenter公共接口
 */

public interface BasePersenter {
    /**
     * 页面初始化数据
     */
    void init();

    void onResume();

    void onDestroy();

    void onDestoryView();
}
