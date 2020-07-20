package com.hhu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/7/9
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGateWay9527 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateWay9527.class,args);
    }
}
