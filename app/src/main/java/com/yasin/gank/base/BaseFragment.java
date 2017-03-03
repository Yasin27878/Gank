package com.yasin.gank.base;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Yasin on 2017/2/27.
 * Email : yasin27878@163.com
 * Description : Fragment 基类
 */

public class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

}
