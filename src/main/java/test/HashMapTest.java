package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @description TODO
 * @createTime 2021年01月25日 15:34:00
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String,String> map=new HashMap<>();
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap<String, Boolean>();
        concurrentHashMap.put("a","a");
        concurrentHashMap.get("a");
        map.put("a","a");
        map.get("a");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }
}
