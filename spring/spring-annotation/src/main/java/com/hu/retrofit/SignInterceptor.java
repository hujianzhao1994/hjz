package com.hu.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Description TODO
 * @Author hjz
 * @Create 2020/12/1 15:44
 **/
@Component
public class SignInterceptor extends BasePathMatchInterceptor {

    private String accessKeyId;

    private String accessKeySecret;

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newReq = request.newBuilder()
                .addHeader("accessKeyId",accessKeyId)
                .addHeader("accessKeySecret",accessKeySecret)
                .build();
        return chain.proceed(newReq);
    }
}
