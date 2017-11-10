package com.company;

import java.util.*;

public class HelloJNI {

    private static Set<Object> referenceCount = new HashSet();

    public static JConnection createConn(String url) {
        System.out.println("[java] createConn : " + url);
        JConnection jConnection = new JConnection(url);
        referenceCount.add(jConnection);
        return jConnection;
    }


    public static void main(String[] args) {
        V8.initialize(System.getProperty("java.library.path"));
        JSContext context = new JSContext();
        context.initialize();
        String s = context.executeScript(
                "var conn = new Connection('jdbc:mysql://boxfish2016outside.mysql.rds.aliyuncs.com:3306/earthshaker_test?useUnicode=true&characterEncoding=utf8');" +
                        "var query = conn.query('select * from dual'); console.log(query); 'abc' "
        );
        System.out.println("[java]" + s);
        System.out.println("[java]====================================================================");
        s = context.executeScript(
                "query"
        );
        System.out.println("[java]" + s);
        context.close();
    }
}
