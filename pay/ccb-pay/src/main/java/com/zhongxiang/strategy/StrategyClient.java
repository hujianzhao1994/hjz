package com.zhongxiang.strategy;

/**
 * @Description TODO
 * 客户端调用
 * @Author hjz
 * @Create 2020/11/6 11:32
 **/
public class StrategyClient {

    public static void main(String[] args) {

        PayChannelContext context = new PayChannelContext(new AlipayChannel());
        Object pay = context.unifiedorder("nin hao ");
        System.out.println(pay);

    }
}
