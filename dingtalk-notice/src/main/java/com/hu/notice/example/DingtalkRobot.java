package com.hu.notice.example;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * @Description TODO
 * 钉钉机器人
 *            安全设置
 *              安全设置目前有3种方式：
 *              
 *              （1）方式一，自定义关键词
 *              
 *              （2）方式二，加签 （本程序中体现）
 *              
 *              （3）方式三，IP地址（段）
 * @Author hjz
 * @Create 2020/11/23 15:05
 **/
public class DingtalkRobot {

    private static final String FIRST = "FIRST";

    private static final String SECOND = "SECOND";

    private static final String THIRD = "THIRD";

    private static final String secret = "SEC0ae714ba2c120573860bcfed0b0f93c3b03584d076d5ada7981aa9b38f4b48a5";

    private static final String accessToken = "b57970c46a59919389504851ab0d8b0e32d6f25c4fe046d4db4e24f898f3fbc2";

    private static final String timestamp = System.currentTimeMillis()+"";

    public static void main(String[] args) throws Exception {

        System.out.println(optionsMethod(SECOND));

    }


    /**
     *      安全设置目前有3种方式：
     *      （1）方式一，自定义关键词
     *      （2）方式二，加签 （本程序中体现）
     *      （3）方式三，IP地址（段）
     *
     * @return
     */
    public static final String optionsMethod(String options) throws Exception {
        String webhook_link_url = "";
        switch (options) {
            case FIRST:
                webhook_link_url = "https://oapi.dingtalk.com/robot/send?access_token=ACCESS_TOKEN";
                webhook_link_url = webhook_link_url.replace("ACCESS_TOKEN",accessToken);
                break;
            case SECOND:
                webhook_link_url = "https://oapi.dingtalk.com/robot/send?access_token=ACCESS_TOKEN&timestamp=TIMESTAMP&sign=SIGN";
                webhook_link_url = webhook_link_url.replace("ACCESS_TOKEN",accessToken)
                        .replace("TIMESTAMP",timestamp)
                        .replace("SIGN",doSign());
                break;
            case THIRD:
                break;
            default:
                break;
        }
        DingTalkClient client = new DefaultDingTalkClient(webhook_link_url);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("监控报警+测试文本消息");
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Arrays.asList("18025304060"));
        // isAtAll类型如果不为Boolean，请升级至最新SDK
        at.setIsAtAll(false);
        request.setAt(at);
        String s = JSONObject.toJSONString(request);
        System.out.println(s);

        OapiRobotSendResponse response = client.execute(request);
        return JSONObject.toJSONString(response);
    }


    /**
     *      加密参数
     * @return
     * @throws Exception
     */
    public static String doSign() throws Exception{
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
        return sign;
    }

}
