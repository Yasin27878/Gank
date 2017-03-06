package com.yasin.gank.base;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.stetho.common.LogUtil;
import com.yasin.gank.annotation.FragmentInject;
import com.yasin.gank.util.SnackbarUtil;

import butterknife.ButterKnife;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Yasin on 2017/2/27.
 * Email : yasin27878@163.com
 * Description : Fragment 基类
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView<T> {
    private String title;

    protected AppCompatActivity activity = null;

    protected int mContentViewId;

    protected T mPresenter;

    protected View fragmentRootView;

    protected ProgressDialog progressDialog = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (getClass().isAnnotationPresent(FragmentInject.class)) {
            FragmentInject annotation = getClass().getAnnotation(FragmentInject.class);
            if (annotation != null) {
                mContentViewId = annotation.contentViewId();
            }
        } else {
            throw new RuntimeException("Class must add annotations of FragmentInject.class");
        }
        fragmentRootView = inflater.inflate(mContentViewId, container, false);
        return fragmentRootView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.onDestoryView();
        }
        try {
            ButterKnife.unbind(this);
        } catch (Exception e) {
            LogUtil.e("this fragment ButterKnife unbind exception" + e.getMessage());
        }
        super.onDestroyView();
    }

    @Override
    public void setPresenter(T presenter) {
        if (presenter != null && mPresenter == null) {
            mPresenter = presenter;
        }
    }

    @Override
    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(activity);
            progressDialog.setMessage("加载中...");
        }
        progressDialog.show();
    }

    @Override
    public void setProgressText(String msg) {
        if (progressDialog != null) {
            progressDialog.setMessage(msg);
        }
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void toast(String msg) {
        SnackbarUtil.showLong(activity, msg);
    }

    @Override
    public void serverError(String msg) {
        SnackbarUtil.showLong(activity, msg);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
