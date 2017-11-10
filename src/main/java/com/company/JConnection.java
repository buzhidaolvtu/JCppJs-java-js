package com.company;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JConnection {

    private final static Logger logger = LoggerFactory.getLogger(JConnection.class);

    private String url;

    public JConnection(String url) {
        this.url = url;
    }

    /**
     * 把结果序列化，单纯返回对象，jni访问遍历非常困难。
     *
     * @param sql
     * @return
     */
    public String query(String sql) {
        logger.info("[java]url is {}",url);
        System.out.println("[java] sql :" + sql);
        List<Map> arrayList = new ArrayList();
        Map e = new HashMap();
        e.put("x0", "y0");
        e.put("x1", "y1");
        arrayList.add(e);
        Map e1 = new HashMap();
        e1.put("x0", "a");
        e1.put("x1", "b");
        e1.put("x2", LocalDateTime.now());
        arrayList.add(e1);

        String s = JSON.toJSONString(arrayList);
        System.out.println("[java]" + s);
        return s;
    }
}
