package com.yasin.gank.mvp.maintab1;

import com.yasin.gank.base.BaseModel;
import com.yasin.gank.base.BasePresenter;
import com.yasin.gank.base.BaseView;
import com.yasin.gank.entity.Information;

import java.util.List;

import rx.Observable;

/**
 * Created by Yasin on 2017/3/6.
 * Email : yasin27878@163.com
 * Description :主页界面的契约类
 */

public class Main1Contract {
    interface Main1Presenter extends BasePresenter {
        void getData(String data);

    }

    interface Main1View extends BaseView<Main1Presenter> {
        //点击选项
        void click(int position);
    }

    interface Main1Model extends BaseModel {
        /**
         * 获取所有信息
         *
         * @param data 日期
         */
        Observable<List<Information>> getAllImformation(String data);
    }

}
