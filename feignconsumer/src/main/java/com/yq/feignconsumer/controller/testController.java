package com.yq.feignconsumer.controller;


import com.yq.feignprovider.feign.providerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * author：yq
 * date: 2020/12/4
 */
@RestController
@RequestMapping("/consumer")
//@CheckUserToken
public class testController {

    @Autowired
    providerFeign providerFeign;
    @RequestMapping(value = "/getMyurlFeign", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> testUrlFeign() {
        Map<String, Object> map = providerFeign.myFeign();
        return map;
    }

    @RequestMapping(value = "/eurekaFeign", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> eurekaFeign() {
        Map<String, Object> map = providerFeign.myFeign();
        return map;
    }
}
