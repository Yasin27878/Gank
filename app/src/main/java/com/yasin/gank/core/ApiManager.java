package com.yasin.gank.core;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.yasin.gank.BuildConfig;
import com.yasin.gank.entity.BaseEntity;
import com.yasin.gank.entity.Information;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description : 网络请求Api接口管理类
 */

public class ApiManager {
    Retrofit mRetrofit;

    public ApiManager(String url) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    /**
     * 获取单例
     */
    public static ApiManager getInstance() {
        return new ApiManager(ConstantApi.BASE_URL + "/");
    }

    /**
     * 初始化 OkHttpClient
     *
     * @return OkHttpClient
     */
    public OkHttpClient getHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(new StethoInterceptor());
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        builder.addInterceptor(interceptor);
        builder.connectTimeout(8, TimeUnit.SECONDS);
        builder.readTimeout(5, TimeUnit.SECONDS);
        builder.writeTimeout(5, TimeUnit.SECONDS);
        return builder.build();
    }

    /**
     * 获取接口服务
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getService(Class<T> tClass) {
        return mRetrofit.create(tClass);
    }


    /**
     * 网络接口
     */
    public interface ApiService {
        /**
         *
         * @param user
         * @return
         */
        @GET("api/{user}/repos")
        Observable<List<BaseEntity<String>>> listRepos(@Path("user") String user);

        /**
         * 获取所有干货
         *
         * @param data
         * @return
         */
        @GET("api/data/Android/{data}")
        Observable<BaseEntity<List<Information>>> getAllImformation(@Path("data") String data);
    }
}
