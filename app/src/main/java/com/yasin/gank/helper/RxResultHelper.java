package com.yasin.gank.helper;


import com.yasin.gank.entity.BaseEntity;
import com.yasin.gank.util.LogUtils;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Rx处理服务器返回
 * Created by YoKey.
 */
public class RxResultHelper {

    /**
     * 列表数据 200 查询成功  500 数据为空
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<BaseEntity<T>, T> handleResult() {
        return tObservable -> tObservable.flatMap(
                (Func1<BaseEntity<T>, Observable<T>>) result -> {
                    LogUtils.i("RxResultHelper " + result.toString());
                    if (result != null) {
                        boolean code = result.error;
                        if (!code) {
                            return createData(result.results);
                        } else {
//                            return Observable.error(new ServerException(code + " " + result.getMessage() + " " + result.getTitle()));
                            return Observable.error(new Exception(result.results.toString()));
                        }
                    } else {
                        return Observable.error(new Exception("返回数据异常 ！！！"));
                    }
                }
        );
    }

    /**
     * 列表数据 200 查询成功  550 数据为空
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<BaseEntity<T>, T> handleListResult() {
        return tObservable -> tObservable.flatMap(
                (Func1<BaseEntity<T>, Observable<T>>) result -> {
                    LogUtils.i("RxResultHelper " + result.toString());
                    if (result != null) {
                        boolean code = result.error;
                        if (!code) {
                            return createData(result.results);
                        } else {
//                            return Observable.error(new ServerException(code + " " + result.getMessage() + " " + result.getTitle()));
                            return Observable.error(new Exception(result.results.toString()));
                        }
                    } else {
                        return Observable.error(new Exception("返回数据异常 ！！！"));
                    }
                }
        );
    }

    /**
     * 返回新的 Observable
     *
     * @param t   泛型
     * @param <T>
     * @return
     */
    private static <T> Observable<T> createData(T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}