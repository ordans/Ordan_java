package com.ordan.portal.util;

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
}
