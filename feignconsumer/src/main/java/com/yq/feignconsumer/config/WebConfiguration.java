package com.yq.feignconsumer.config;

import com.gdtopway.auth.client.interceptor.UserAuthRestInterceptor;
import com.gdtopway.common.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Collections;

@Configuration("admimWebConfig")
@Primary
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    /**
     * 配置服务验证和用户验证
     * commonPathPatterns.add("/user/validate")添加忽略用户验证的路径
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> commonPathPatterns = getExcludeCommonPathPatterns();
        registry.addInterceptor(getUserAuthRestInterceptor()).addPathPatterns("/**").excludePathPatterns(commonPathPatterns.toArray(new String[]{}));

        super.addInterceptors(registry);
    }


    @Bean
    UserAuthRestInterceptor getUserAuthRestInterceptor() {
        return new UserAuthRestInterceptor();
    }

    /**
     * 获取排除公共路径模式
     * @return
     */
    private ArrayList<String> getExcludeCommonPathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/v2/api-docs",
                "/swagger-resources/**",
                "/cache/**",
                "/api/log/save"
        };
        Collections.addAll(list, urls);
        return list;
    }
}
