package com.ordan.portal.util;

import java.util.ResourceBundle;

public class PortUtil {

    static ResourceBundle rb;
    static {
        rb = ResourceBundle.getBundle("dataSource");
    }

    public static String getValue(int r) {
        String s = rb.getString("" + r);

        return s;

    }
}
