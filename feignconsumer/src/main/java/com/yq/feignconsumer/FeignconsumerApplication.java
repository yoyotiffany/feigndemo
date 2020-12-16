package com.yq.feignconsumer;

import com.gdtopway.auth.client.EnableAceAuthClient;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.yq.feignconsumer"})
@EnableAceAuthClient
@EnableSwagger2Doc
@EnableEurekaClient
@EnableFeignClients({"com.yq.feignconsumer.feign","com.gdtopway.auth.client.feign"})
public class FeignconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignconsumerApplication.class, args);
    }

}
