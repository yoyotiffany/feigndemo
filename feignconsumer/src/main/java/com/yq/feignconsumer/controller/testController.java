package com.yq.feignconsumer.controller;

import com.gdtopway.auth.client.annotation.CheckUserToken;
import com.yq.feignconsumer.feign.eurekaFeign;
import com.yq.feignconsumer.feign.urlFeign;
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
@CheckUserToken
public class testController {
    @Autowired
    urlFeign urlFeign;

    @Autowired
    eurekaFeign eurekaFeign;

    @RequestMapping(value = "/getMyurlFeign", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> testUrlFeign() {
        Map<String, Object> map = urlFeign.urlFeign();
        return map;
    }

    @RequestMapping(value = "/eurekaFeign", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> eurekaFeign() {
        Map<String, Object> map = eurekaFeign.eurekaFeign();
        return map;
    }
}
