package com.yasin.gank.mvp.maintab1;

import com.yasin.gank.base.BasePresenterImpl;
import com.yasin.gank.base.BaseView;
import com.yasin.gank.entity.Information;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by Yasin on 2017/3/6.
 * Email : yasin27878@163.com
 * Description :
 */

public class Main1Presenter extends BasePresenterImpl implements Main1Contract.Main1Presenter {
    Main1Contract.Main1Model model;

    public Main1Presenter(BaseView mView) {
        super(mView);
        model = new Main1Model();
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
    public void getData(String data) {
        model.getAllImformation(data).subscribe(new Action1<List<Information>>() {
            @Override
            public void call(List<Information> informations) {

            }
        });
    }
}
