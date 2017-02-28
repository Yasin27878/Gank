package com.yasin.gank.base;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description : View层公共接口
 */

public interface BaseView<T> {
    /**
     * 使用fragment作为view时，将activity中的presenter传递给fragment
     *
     * @param presenter
     */
    void setPresenter(T presenter);

    void showProgress();

    void setProgressText(String msg);

    void hideProgress();

    void toast(String msg);

    /**
     * 服务器返回数据异常
     *
     * @param msg
     */
    void serverError(String msg);


}
