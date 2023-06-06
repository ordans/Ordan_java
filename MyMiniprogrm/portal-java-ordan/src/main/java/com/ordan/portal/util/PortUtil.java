package com.ordan.portal.util;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class PortUtil {

    static ResourceBundle rb;
    static {//在静态代码块初始化，只运行一次
        rb = ResourceBundle.getBundle("dataSource");
    }

    public static String getValue(int r) { //r状态码
        String s = rb.getString("" + r);
        try {
            s = new String(s.getBytes("iso-8859-1"),"UTF-8");//检查异常
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return s;

    }


    public static String send(String mobile,String content){

        //读取配置文件
        String url      = rb.getString("dx.url");
        String appcode  = rb.getString("ordan.appcode");
        String sign     = rb.getString("ordan.qianming");
        String template = rb.getString("ordan.moban");
        String type     = "application/x-www-form-urlencoded;charset=UTF-8";

        //开始定义网络调用
        //定义一个客户端对象
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        //构造一个请求体对象
        RequestBody requestBody = new FormBody.Builder()  //创建
                .add("mobile",mobile)               //绑定参数:手机号码
                .add("smsSignId",sign)              //绑定参数:短信签名
                .add("templateId",template)         //绑定参数:短信模板
                .add("param","**code**:" + buildYzf() + ",**minute**:" + 5)         //绑定参数:模板变量
                .build();                                 //生成

        //构造请求头对象
        Request request = new Request.Builder()           //创建
                .url(url)                                 //指定请求地址
                .method("POST",requestBody)       //指定请求方法
                .addHeader("Content-Type",type)             //指定内容类型
                .addHeader("Authorization","APPCODE " + appcode)             //指定身份参数
                .build();                                 //生成请求对象

        String str = null;
        try {
            str = client.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("调用结果=" + str);
        return str;
    }

    private static String buildYzf() {

        String str = "0123456789";
        StringBuilder builder = new StringBuilder();

        for (int i = 0;i < 4; i ++){
            int x = (int) ( Math.random() * str.length() );
            char s = str.charAt(x);
            builder.append(s);
        }

        return builder.toString();
    }

//    public static void main(String[] args) {
//        PortUtil.send("15220957196","");
//    }

}
