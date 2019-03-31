package com.scut.leaflet.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.scut.leaflet.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@RestController
@RequestMapping("/api/wx")
public class WxController {

    private static Logger log = LoggerFactory.getLogger(WxController.class);

    @Value("wxe5d3f3476356333c")
    private String appId;

    @Value("2ebf2f1f882adf48d5295670e76d6b0c")
    private String appSecret;

    @Value("authorization_code")
    private String grantType;
    // wx.grantType=authorization_code

    @Value("https://api.weixin.qq.com/sns/jscode2session")
    private String requestUrl;
    // wx.requestUrl=https://api.weixin.qq.com/sns/jscode2session

    @RequestMapping("/session")
    public Map<String, Object> getSession(@RequestParam(required = true) String code) {
        log.debug("请求地址：{}", code );
        System.out.println("已经执行改操作");
        System.out.println(code);
        return this.getSessionByCode(code);
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> getSessionByCode(String code) {
        String url = this.requestUrl + "?appid=" + appId + "&secret=" + appSecret + "&js_code=" + code + "&grant_type="
                + grantType;
        // 发送请求
        System.out.println(url);
        String data = HttpUtil.get(url);
        log.debug("请求地址：{}", url);
        log.debug("请求结果：{}", data);
        System.out.print("发送亲求");
        ObjectMapper mapper = new ObjectMapper();
        System.out.print("data="+data);
        Map<String, Object> json = null;
        try {
            json = mapper.readValue(data, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,Object> test= new HashMap<>();
        // 形如{"session_key":"6w7Br3JsRQzBiGZwvlZAiA==","openid":"oQO565cXXXXXEvc4Q_YChUE8PqB60Y"}的字符串
        if(!json.containsKey("openid"))
        {
         return json;
        }
        UUID uuid = UUID.randomUUID();
        System.out.println("uuid:"+uuid);
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        System.out.println("temp:"+temp);

        System.out.println("temp:"+uuid);
        test.put("uuid",temp);



        return test;
    }
}


