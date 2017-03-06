package com.yasin.gank.mvp.maintab1;

/**
 * Created by Yasin on 2017/3/6.
 * Email : yasin27878@163.com
 * Description :
 */

public interface Callback<T> {
    void onSuccess(T t);

    void onFauiled();
}
