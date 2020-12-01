package com.hu.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.annotation.Intercept;
import com.github.lianjiatech.retrofit.spring.boot.annotation.OkHttpClientBuilder;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import okhttp3.OkHttpClient;
import okio.Timeout;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * 自定义okhttpClient
 * @Author hjz
 * @Create 2020/12/1 14:22
 **/
@RetrofitClient(baseUrl = "${test.baseUrl}")
@Intercept(handler = TimeStampInterceptor.class,include = {"/shop/category/opt/listAll"},exclude = {"/retrofit/**"})
public interface  HttpApi2 {

    @OkHttpClientBuilder
     static OkHttpClient.Builder okHttpClientBuilder(){
        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1,TimeUnit.SECONDS)
                .writeTimeout(1,TimeUnit.SECONDS);
    }


    @GET("listAll")
    Object listAll();

    @GET("retrofit")
    Object retrofit(@Query("id") String id);

}
