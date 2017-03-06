package com.yasin.gank.mvp.maintab1;

import com.yasin.gank.base.BaseModelImpl;
import com.yasin.gank.core.GankApplication;
import com.yasin.gank.entity.BaseEntity;
import com.yasin.gank.entity.Information;
import com.yasin.gank.helper.RxResultHelper;
import com.yasin.gank.helper.RxSchedulersHelper;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Yasin on 2017/3/6.
 * Email : yasin27878@163.com
 * Description :
 */

public class Main1Model extends BaseModelImpl implements Main1Contract.Main1Model {

    @Override
    public Observable<List<Information>> getAllImformation(String data) {
        return GankApplication.mService.getAllImformation(data)
                .compose(RxSchedulersHelper.applyIoToMain())
                .compose(RxResultHelper.handleListResult());
    }

}
