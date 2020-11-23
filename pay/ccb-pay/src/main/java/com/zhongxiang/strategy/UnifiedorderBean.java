package com.zhongxiang.strategy;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * 统一下单
 * @Author hjz
 * @Create 2020/11/18 16:54
 **/
@Data
public class UnifiedorderBean implements Serializable {

    private String merchantid;
    private String posid;
    private String branchid;
    private String orderid;
    private String payment;
    private String curcode;
    private String remark1;
    private String remark2;
    private String txcode;
    private String mac;
    private String type;
    private String pub;
    private String gateway;
    private String clientip;
    private String reginfo;
    private String proinfo;
    private String referer;
    private String timeout;
    private String trade_type;
    private String  sub_appid;
    private String  sub_openid;
    private String wx_channelid;

    //二级商户信息,若上送二级商户信息则八个二级商户信息字段必须都送值，当该字段有值时参与MAC校验，否则不参与MAC校验。
    private String smerid;
    private String smername;
    private String smertypeid;
    private String smertype;
    private String tradecode;
    private String tradename;
    private String smeprotype;
    private String proname;





}
