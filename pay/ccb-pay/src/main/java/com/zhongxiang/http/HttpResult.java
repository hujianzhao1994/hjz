package com.zhongxiang.http;

/**
 * @Description TODO
 * http  响应结果
 * @Author hjz
 * @Create 2020/11/6 14:30
 **/

public class HttpResult {

    // 响应码
    private Integer code;

    // 响应体
    private String body;


    public HttpResult() {
        super();
    }

    public HttpResult(Integer code, String body) {
        super();
        this.code = code;
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}