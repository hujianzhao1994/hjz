package com.zhongxiang.strategy;

import com.zhongxiang.http.HttpApiService;
import com.zhongxiang.http.HttpResult;
import com.zhongxiang.util.MD5;
import org.apache.http.protocol.HttpService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * 建行龙支付渠道
 * @Author hjz
 * @Create 2020/11/6 11:41
 **/
public class CCBpayChannel extends PayChannelStrategy {


    @Autowired
    HttpApiService httpApiService;


    @Override
    public Object pay(Object obj) {
        System.out.println(this.getClass().getCanonicalName());
        String bankURL="https://ibsbjstar.ccb.com.cn/CCBIS/ccbMain";
        bankURL="http://124.127.94.61:8001/CCBIS/ccbMain";

        String MERCHANTID = "105421097080009";
        String POSID = "902807340";
        String BRANCHID = "360000000";
        String ORDERID = "111111111111";
        String PAYMENT= "0.01";
        String CURCODE="01";
        String TXCODE = "530550";
        String REMARK1 = "";
        String REMARK2 = "";
        String RETURNTYPE="1";
        String TIMEOUT = "";
        String PUB32TR2= "f6528d5c335b7092fc9ec1b3020111";

        StringBuffer tmp = new StringBuffer(); //验签字段
        tmp.append("MERCHANTID=");
        tmp.append(MERCHANTID);
        tmp.append("&POSID=");
        tmp.append(POSID);
        tmp.append("&BRANCHID=");
        tmp.append(BRANCHID);
        tmp.append("&ORDERID=");
        tmp.append(ORDERID);
        tmp.append("&PAYMENT=");
        tmp.append(PAYMENT);
        tmp.append("&CURCODE=");
        tmp.append(CURCODE);
        tmp.append("&TXCODE=");
        tmp.append(TXCODE);
        tmp.append("&REMARK1=");
        tmp.append(REMARK1);
        tmp.append("&REMARK2=");
        tmp.append(REMARK2);
        tmp.append("&RETURNTYPE=");
        tmp.append(RETURNTYPE);
        tmp.append("&TIMEOUT=");
        tmp.append(TIMEOUT);
        tmp.append("&PUB=");
        tmp.append(PUB32TR2);

        Map map = new HashMap();
        map.put("CCB_IBSVersion","V6");	//必输项
        map.put("MERCHANTID",MERCHANTID);
        map.put("BRANCHID",BRANCHID);
        map.put("POSID",POSID);
        map.put("ORDERID",ORDERID);
        map.put("PAYMENT",PAYMENT);
        map.put("CURCODE",CURCODE);
        map.put("TXCODE",TXCODE);
        map.put("REMARK1",REMARK1);
        map.put("REMARK2",REMARK2);
        map.put("RETURNTYPE",RETURNTYPE);
        map.put("TIMEOUT",TIMEOUT);
        map.put("MAC", MD5.md5Str(tmp.toString()));


        HttpResult ret = null;
        try {
            ret = httpApiService.doPost(bankURL, map);
            System.out.println("ret::"+ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Object notify(Object obj) {

        return null;
    }


}

