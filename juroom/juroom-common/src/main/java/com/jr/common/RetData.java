package com.jr.common;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

public class RetData<T> {
    private int code;
    private String msg;
    @JsonIgnore
    private Map<String, String> map = new HashMap();
    private T body;

    public RetData() {
    }

    public String getValue(String key) {
        return (String)this.map.get(key);
    }

    public String setValue(String key, String value) {
        return (String)this.map.put(key, value);
    }

    public static RetData errorData(String vmsg) {
        return new RetData(700, vmsg);
    }

    public static RetData errorRights(String vmsg) {
        return new RetData(750, vmsg);
    }

    public static RetData errorSystem(String vmsg) {
        return new RetData(770, vmsg);
    }

    public static RetData errorThirdSystem(String vmsg) {
        return new RetData(790, vmsg);
    }

    public static RetData error(int code, String vmsg) {
        return new RetData(code, vmsg);
    }

    public RetData(int vcode, String vmsg) {
        this.code = vcode;
        this.msg = vmsg;
    }

    public static RetData success() {
        return new RetData(0, "成功");
    }

    public static RetData success(Object vbody) {
        RetData RetData = new RetData(0, "成功");
        RetData.setBody(vbody);
        return RetData;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int status) {
        this.code = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return this.body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
