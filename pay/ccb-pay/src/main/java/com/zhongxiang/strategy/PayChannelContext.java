package com.zhongxiang.strategy;

/**
 * @Description TODO  策略模式：https://www.cnblogs.com/adamjwh/p/11011095.html
 * 支付业务接口
 * @Author hjz
 * @Create 2020/11/6 11:13
 **/
public class PayChannelContext {

    private PayChannelStrategy strategy;

    public PayChannelContext(PayChannelStrategy strategy) {
        this.strategy = strategy;
    }

    public Object unifiedorder(Object  obj){
        return  strategy.unifiedorder(obj);
    }


    /**
     *      商 户 通 知 接 口
     * @param obj
     * @return
     */
    public Object notify(Object obj){
        return strategy.notify(obj);
    }
}
