package com.yasin.gank.base;

import com.yasin.gank.callback.RequestCallback;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description :Persenter实现类
 */

public class BasePresenterImpl<T extends BaseView, V> implements BasePresenter, RequestCallback<V> {
    public T mView;

    public BasePresenterImpl(T mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void init() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onDestoryView() {

    }

    @Override
    public void requestError(String msg) {
        mView.showProgress();
    }

    @Override
    public void requestSuccess(V data) {
        mView.hideProgress();
    }
}
