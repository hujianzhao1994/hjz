package com.zhongxiang.strategy;

/**
 * @Description TODO
 * 微信支付渠道
 * @Author hjz
 * @Create 2020/11/6 11:31
 **/
public class WxpayChannel extends PayChannelStrategy {
    @Override
    public Object pay(Object obj) {
        System.out.println(this.getClass().getCanonicalName());
        System.out.println("wxPay.......");
        return obj;
    }
}
