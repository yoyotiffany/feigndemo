package com.yq.feignconsumer;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.yq.feignconsumer","com.yq.feignprovider.config"})
@EnableSwagger2Doc
@EnableEurekaClient
@EnableFeignClients({"com.yq.feignprovider.feign",/**"com.gdtopway.auth.client.feign"**/})
//@EnableAceAuthClient
public class FeignconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignconsumerApplication.class, args);
    }

}
