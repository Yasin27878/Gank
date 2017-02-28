package com.yasin.gank.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description :
 */

public class SpfHelper {

    private SharedPreferences sp;

    private volatile static SpfHelper instance;

    private static SharedPreferences.Editor editor;

    public SpfHelper(Context context, String name) {
        if (this.sp == null) {
            synchronized (SharedPreferences.class) {
                if (this.sp == null) {
                    this.sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
                }
            }
        }

        editor = sp.edit();
    }

    public static synchronized SpfHelper getInstance(Context context, String name) {
        if (instance == null) {
            synchronized (SpfHelper.class) {
                if (instance == null) {
                    instance = new SpfHelper(context, name);
                }
            }
        }
        return instance;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    public SpfHelper saveNoCommit(String key, Object value) {
        if (value instanceof String) {
            getEditor().putString(key, TextUtils.isEmpty((String) value) ? "" : (String) value);
        } else if (value instanceof Integer) {
            getEditor().putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            getEditor().putBoolean(key, (Boolean) value);
        }
        return this;
    }

    public void apply() {
        if (getEditor() != null) {
            getEditor().apply();
        }
    }

    public String getString(String key) {
        return sp.getString(key, "");
    }

    public int getInt(String key) {
        return sp.getInt(key, 0);
    }

    public Boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }


}
