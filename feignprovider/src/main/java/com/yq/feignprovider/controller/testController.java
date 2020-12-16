package com.yq.feignprovider.controller;

import com.gdtopway.auth.client.annotation.CheckUserToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * author：yq
 * date: 2020/12/15
 */
@RestController
@CheckUserToken
@RequestMapping("/myFeign")
public class testController {

    @RequestMapping(value = "/urlFeign", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> testUrlFeign() {
        // 设置服务超时
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","success to get urlFeign data");
        return map;
    }

    @RequestMapping(value = "/eurekaFeign", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> eurekaFeign() {
        //发生异常
        //int a=9/0;

       // 设置服务超时
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","success to get eurekaFeign data");
        return map;
    }

}
