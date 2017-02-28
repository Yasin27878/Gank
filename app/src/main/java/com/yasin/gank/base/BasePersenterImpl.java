package com.yasin.gank.base;

import com.yasin.gank.callback.RequestCallback;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description :Persenter实现类
 */

public class BasePersenterImpl<T extends BaseView, V> implements BasePersenter, RequestCallback<V> {
    protected T mView;

    public BasePersenterImpl(T mView) {
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
