package com.company;

import java.util.*;

public class HelloJNI {

    private static native void hehe();

    // Declare a native method sayHello() that receives nothing and returns void
    private native void sayHello();

    private native void sayHello(String hello);

    private native String executeScript(String script);

    public static void hello2() {
        System.out.println("hello2");
    }

    private static Set<Object> referenceCount = new HashSet();

    public static JConnection createConn(String url) {
        System.out.println("[java] createConn : " + url);
        JConnection jConnection = new JConnection(url);
        referenceCount.add(jConnection);
        return jConnection;
    }


    public static void main(String[] args) {
        V8.initialize("/Users/lvtu/Library/Developer/Xcode/DerivedData/v8-hello-world-cwwhrrfzjyeesxhchgyxuueyceek/Build/Products/Debug/");
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
