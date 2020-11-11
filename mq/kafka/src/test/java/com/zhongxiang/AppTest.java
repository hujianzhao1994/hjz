package com.zhongxiang;

import static org.junit.Assert.assertTrue;

import com.zhongxiang.base.OneProducer;
import org.junit.Test;


public class AppTest {

    OneProducer oneProducer;

    @Test
    public void shouldAnswerWithTrue()
    {
        oneProducer = new OneProducer();
        oneProducer.sendMsg();
    }
}
