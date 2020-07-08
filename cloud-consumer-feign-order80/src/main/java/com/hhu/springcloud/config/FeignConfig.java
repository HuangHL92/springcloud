package com.hhu.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/7/6
 * @version: 1.0
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }

}
