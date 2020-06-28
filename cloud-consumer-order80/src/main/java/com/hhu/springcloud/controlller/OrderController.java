package com.hhu.springcloud.controlller;

import com.hhu.springcloud.entities.CommonResult;
import com.hhu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/6/24
 * @version: 1.0
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Integer id){
         String path = "http://localhost:8001/payment/get/";
        return restTemplate.getForObject(path+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        String path = "http://localhost:8001/payment/create";
        return restTemplate.postForObject(path,payment,CommonResult.class);
    }

}
