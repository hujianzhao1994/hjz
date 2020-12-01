package com.hu.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * @Description TODO
 * 定义 retrofit 接口
 * @Author hjz
 * @Create 2020/12/1 9:36
 **/
@RetrofitClient(baseUrl = "${test.baseUrl}")
@Sign(accessKeyId = "${test.accessKeyId}", accessKeySecret = "${test.accessKeySecret}", exclude = {"/api/test/person"})
public interface HttpApi {

    @GET("listAll")
    Object listAll();

    @GET("retrofit")
    Object retrofit(@Query("id") String id);

}
