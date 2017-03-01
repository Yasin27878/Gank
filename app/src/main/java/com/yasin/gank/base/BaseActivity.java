package com.yasin.gank.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.yasin.gank.R;
import com.yasin.gank.util.SystemBarTintManager;

/**
 * Created by Yasin on 2017/2/27.
 * Email : yasin27878@163.com
 * Description :Activity 基类
 */

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView<T> {
    protected int colorPrim = R.color.colorPrimary;
    protected T mPresenter;
    protected ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isTranslate()) {
            setTranslate();
        }
    }

    /**
     * 设置是否打开透明状态栏
     *
     * @return
     */
    protected boolean isTranslate() {
        return true;
    }

    /**
     * 获取 mPresenter对象
     *
     * @return
     */
    public T getmPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(T presenter) {

    }

    @Override
    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
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

    }

    @Override
    public void serverError(String msg) {

    }

    /**
     * 设置沉浸式状态栏
     */
    protected void setTranslate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
            systemBarTintManager.setStatusBarTintEnabled(true);
            systemBarTintManager.setStatusBarTintResource(colorPrim);
            systemBarTintManager.setNavigationBarAlpha(0.2f);
        }
    }

    /**
     * 设置半透明状态
     *
     * @param on
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
