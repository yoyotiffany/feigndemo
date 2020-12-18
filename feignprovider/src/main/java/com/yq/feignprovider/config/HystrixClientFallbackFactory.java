package com.yq.feignprovider.config;

import com.yq.feignprovider.feign.providerFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * author：yq
 * date: 2020/12/17
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<providerFeign> {
    @Override
    public providerFeign create(Throwable cause) {
        return new providerFeign() {
            @Override
            public Map<String,Object> myFeign() {
                Map<String,Object> map=new HashMap<>();
                map.put("code", 500);
                map.put("msg", cause.getMessage());
                return map;
            }
        };
    }
}
