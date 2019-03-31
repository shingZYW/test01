package com.scut.leaflet.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ass we can!
 * created by shing
 * 2019-03-26 17:28
 */
public class key {
    public static String unique() {

        Map<String,Object> test = new HashMap<>();
        UUID uuid = UUID.randomUUID();


       // System.out.println("uuid:" + uuid);
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        //String temp = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
/*        System.out.println("temp:" + temp);
	at com.scut.leaflet.controller.key.unique(key.java:18)

        System.out.println("temp:" + uuid);*/
        test.put("temp", temp);
        return temp;
    }



/*    public static  void main(String[] args){
        for(int i =1;i<5;i++) {
            String openid = "asdasd";
            System.out.println("这是第" + i + "个UUID：" + key.unique(openid));
        }




    }*/
}
