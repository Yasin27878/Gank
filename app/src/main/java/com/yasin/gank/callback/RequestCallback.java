package com.yasin.gank.callback;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description :网络请求接口回调
 */

public interface RequestCallback<T> {

    void requestError(String msg);

    void requestSuccess(T data);
}
