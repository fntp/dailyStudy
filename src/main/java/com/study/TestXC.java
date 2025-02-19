package com.study;

import jdk.internal.util.ArraysSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fntp
 * @date 2025/1/16
 * @apiNote
 */
public class TestXC {

    public static void main(String[] args) {
        //HashMap<String,String> map1 = new HashMap<>();
        //ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        //map.put(null,null);
        //map1.put(null,"scx");
        //System.out.println(map1.get(null));
        //System.out.println(map.get(null));
        System.out.println(10 >> 1);
        //int newCapacity = ArraysSupport.newLength(10,
        //        11 - 10, /* minimum growth */
        //        10 >> 1);
        //System.out.println(newCapacity);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.ensureCapacity(100);
        //System.out.println(integers);
    }

}
