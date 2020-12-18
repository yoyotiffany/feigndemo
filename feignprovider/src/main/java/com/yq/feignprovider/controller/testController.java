package com.yq.feignprovider.controller;

import com.yq.feignprovider.service.Imp.feignServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/provider")
//@CheckUserToken
public class testController {

    @Autowired
    feignServiceImp feignServiceImp;

    @RequestMapping(value = "/MyFeign", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> MyFeign() {


        return feignServiceImp.myFeign();
    }



}
