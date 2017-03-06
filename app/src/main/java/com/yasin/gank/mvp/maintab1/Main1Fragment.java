package com.yasin.gank.mvp.maintab1;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.yasin.gank.R;
import com.yasin.gank.annotation.FragmentInject;
import com.yasin.gank.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Yasin on 2017/3/6.
 * Email : yasin27878@163.com
 * Description :主页
 */
@FragmentInject(contentViewId = R.layout.fragment_main1)
public class Main1Fragment extends BaseFragment {
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @Bind(R.id.xrefreshview)
    XRefreshView mXrefreshview;

    private String mParam1;

    public Main1Fragment() {
    }

    public static Main1Fragment newInstance(String param1, String param2) {
        Main1Fragment fragment = new Main1Fragment();
        Bundle args = new Bundle();
        args.putString("ARG_PARAM", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("ARG_PARAM");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
