package com.yq.feignconsumer.feign;



import com.gdtopway.auth.client.config.FeignApplyConfiguration;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * author：yq
 * date: 2020/12/4
 * hr-employee
 */
@FeignClient(name = "feignprovider", url = "http://127.0.0.1:10099", fallbackFactory = HystrixClientFallbackFactory.class,configuration = {FeignApplyConfiguration.class})
public interface urlFeign {
    @RequestMapping(value = "/myFeign/urlFeign", method = RequestMethod.GET)
    public Map<String,Object> urlFeign();

}


@Component
class HystrixClientFallbackFactory implements FallbackFactory<urlFeign> {
    //这种写法，当服务调用超时或者无法调用时直接走该方法并接受Throwable cause服务异常原因
    @Override
    public urlFeign create(Throwable cause) {
        return new urlFeign() {

            @Override
            public Map<String, Object> urlFeign() {
                Map<String,Object> map=new HashMap<>();
                map.put("code",500);
                map.put("msg",cause.getMessage());
                return map;
            }

        };
    }
}