package com.yq.feignprovider.service.Imp;

import com.yq.feignprovider.feign.providerFeign;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * author：yq
 * date: 2020/12/17
 */
@Service
public class feignServiceImp implements providerFeign {
    @Override
    public Map<String, Object> myFeign() {
        //int a=9/0;
        // 设置服务超时
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> map=new HashMap<>();
        map.put("code",200);
        map.put("msg","success to get provider data");
        return map;
    }
}
