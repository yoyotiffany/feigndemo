package com.yq.feignprovider.feign;

import com.yq.feignprovider.config.HystrixClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

/**
 * author：yq
 * date: 2020/12/17
 */
@FeignClient(name = "feignprovider",/**configuration = {FeignApplyConfiguration.class}**/fallbackFactory =HystrixClientFallbackFactory.class)
public interface providerFeign {

    @RequestMapping(value = "/provider/MyFeign", method = RequestMethod.GET)
    public Map<String,Object> myFeign();

}

