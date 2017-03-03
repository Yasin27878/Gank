package com.yasin.gank.mvp.main;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yasin.gank.R;
import com.yasin.gank.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.message)
    TextView mTextMessage;
    @Bind(R.id.content)
    FrameLayout mContent;
    @Bind(R.id.navigation)
    BottomNavigationView mNavigation;
    @Bind(R.id.container)
    LinearLayout mContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_person:
                    mTextMessage.setText(R.string.title_persion);
                    return true;
            }
            return false;
        });
    }

}
