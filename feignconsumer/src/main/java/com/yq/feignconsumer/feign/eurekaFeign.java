package com.yq.feignconsumer.feign;

import com.gdtopway.auth.client.config.FeignApplyConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * author：yq
 * date: 2020/12/15
 */
@FeignClient(name = "feignprovider",configuration = {FeignApplyConfiguration.class})
public interface eurekaFeign {

    @RequestMapping(value = "/myFeign/eurekaFeign", method = RequestMethod.GET)
    public Map<String,Object> eurekaFeign();

}

@Component
 class HystrixClientFallback implements eurekaFeign {

    //这种写法，当服务调用超时或者无法调用时直接走该方法
    @Override
    public Map<String, Object> eurekaFeign() {
        Map<String,Object> map=new HashMap<>();
        map.put("code",500);
        map.put("msg","服务调用异常");
        return map;
    }
}