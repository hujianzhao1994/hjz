package com.zhongxiang.strategy;

/**
 * @Description TODO
 * 支付策略
 * @Author hjz
 * @Create 2020/11/6 11:12
 **/
public abstract class PayChannelStrategy {



    public abstract Object pay(Object obj);

    // 商户 通知 接口
    public abstract Object notify(Object obj);
}
