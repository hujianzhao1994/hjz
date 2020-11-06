package strategy;

import com.zhongxiang.PayStarter;
import com.zhongxiang.http.HttpApiService;
import com.zhongxiang.http.HttpResult;
import com.zhongxiang.util.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * 测试类
 * @Author hjz
 * @Create 2020/11/6 14:44
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PayStarter.class)
public class StrategyTest {

    @Resource
    HttpApiService httpApiService;

    @Test
    public void CCBpayTest() throws Exception {
//        HttpResult httpResult = httpApiService.doPost("http://mall.zhongxiang51.com/shop/category/opt/listAll");
//        System.out.println(httpResult.getBody());
        String s = httpApiService.doGet("http://mall.zhongxiang51.com/shop/category/opt/listAll");
        System.out.println(s);
    }


    @Test
    public void test2() throws Exception {

        String MERCHANTID ="105421097080009";
        String BRANCHID="360000000";                 //分行代码
        String POSID="902807340";                    //柜台号
        String ORDERDATE="20160811";                  //订单日期
        String BEGORDERTIME="00:00:00";
        String ENDORDERTIME="23:59:59";
        String BEGORDERID="";
        String ENDORDERID="";
        String QUPWD="111111";
        String TXCODE="410408";
        String SEL_TYPE="3";
        String OPERATOR="";

        //txcode=410408
        String TYPE="0";
        String KIND="0";
        String STATUS="0";
        String ORDERID = "16112150000266";
        String PAGE = "1";
        String CHANNEL = "";

        String bankURL="https://ibsbjstar.ccb.com.cn/app/ccbMain";
//        bankURL="http://128.128.96.118:8001/app/ccbMain";
//        bankURL="http://128.192.122.68:8101/CCBIS/ccbMain";

        String param ="MERCHANTID="+MERCHANTID+"&BRANCHID="+BRANCHID+"&POSID="+POSID+"&ORDERDATE="+ORDERDATE+"&BEGORDERTIME="+BEGORDERTIME
                +"&ENDORDERTIME="+ENDORDERTIME+"&BEGORDERID="+BEGORDERID+"&ENDORDERID="+ENDORDERID+"&QUPWD=&TXCODE="+TXCODE
                +"&SEL_TYPE="+SEL_TYPE+"&OPERATOR="+OPERATOR;

        if("410408".equals(TXCODE)){
            param ="MERCHANTID="+MERCHANTID+"&BRANCHID="+BRANCHID+"&POSID="+POSID+"&ORDERDATE="
                    +ORDERDATE+"&BEGORDERTIME="+BEGORDERTIME+"&ENDORDERTIME="+ENDORDERTIME+"&ORDERID="
                    +ORDERID+"&QUPWD=&TXCODE="+TXCODE+"&TYPE="+TYPE+"&KIND="+KIND+"&STATUS="+STATUS+
                    "&SEL_TYPE="+SEL_TYPE+"&PAGE="+PAGE+"&OPERATOR="+OPERATOR+"&CHANNEL="+CHANNEL;
        }


        System.out.println("-----"+MD5.md5Str(param));

        Map map = new HashMap();
        map.put("MERCHANTID",MERCHANTID);

        map.put("BRANCHID",BRANCHID);
        map.put("POSID",POSID);

        map.put("ORDERDATE",ORDERDATE);

        map.put("BEGORDERTIME",BEGORDERTIME);

        map.put("ENDORDERTIME",ENDORDERTIME);

        map.put("BEGORDERID",BEGORDERID);

        map.put("ENDORDERID",ENDORDERID);

        map.put("QUPWD",QUPWD);

        map.put("TXCODE",TXCODE);

        if("410408".equals(TXCODE)){
            map.put("TYPE",TYPE);
            map.put("KIND",KIND);
            map.put("STATUS",STATUS);
            map.put("ORDERID",ORDERID);
            map.put("PAGE",PAGE);
            map.put("CHANNEL",CHANNEL);
        }


        map.put("SEL_TYPE",SEL_TYPE);

        map.put("OPERATOR",OPERATOR);

        map.put("MAC", MD5.md5Str(param));

        System.out.println(bankURL);
        HttpResult ret = httpApiService.doPost(bankURL, map);

        System.out.println("ret::"+ret.getBody());
    }
}
