package com.zhongxiang.strategy;

/**
 * @Description TODO
 * 支付宝支付渠道
 * @Author hjz
 * @Create 2020/11/6 11:31
 **/
public class AlipayChannel extends PayChannelStrategy {
    @Override
    public Object pay(Object obj) {
        System.out.println(this.getClass().getCanonicalName());
        System.out.println("alipay.......");
        return obj;
    }


    @Override
    public Object notify(Object obj) {
        return null;
    }
}
