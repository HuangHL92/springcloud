package com.hhu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/6/24
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class Oder80 {
    public static void main(String[] args) {
        SpringApplication.run(Oder80.class,args);
    }

}
