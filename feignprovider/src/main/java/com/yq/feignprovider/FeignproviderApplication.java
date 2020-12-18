package com.yq.feignprovider;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.yq.feignprovider"})
@EnableSwagger2Doc
@EnableFeignClients({"com.yq.feignprovider.feign"/**,"com.gdtopway.auth.client.feign"**/})
//@EnableAceAuthClient
public class FeignproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignproviderApplication.class, args);
    }

}
