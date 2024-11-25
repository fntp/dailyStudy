package com.xuexi.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author fntp
 * @since 2024/11/25
 */
public class BaseHashMap {

    public static HashMap hashMap = new HashMap(11);

    public static void main(String[] args) {
        System.out.println(-1 >>> 16);
        System.out.println(-1 >> 16);
        System.out.println(1 >>> 16);

        hashMap.put("k1", "v1");
        Object put1 = hashMap.put("k1", "v2");
        System.out.println(put1);

        List<Object> list = Collections.synchronizedList(new ArrayList<>());

    }
 }
