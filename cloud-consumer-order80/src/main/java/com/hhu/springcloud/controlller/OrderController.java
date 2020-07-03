package com.hhu.springcloud.controlller;

import com.hhu.springcloud.entities.CommonResult;
import com.hhu.springcloud.entities.Payment;
import com.hhu.springcloud.lb.MyLb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    MyLb myLb;

    public static final String path = "http://cloud-payment-service";
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Integer id){
         String realPath = path + "/payment/get/";
        return restTemplate.getForObject(realPath+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        String realPath = path + "/payment/create";
        return restTemplate.postForObject(realPath,payment,CommonResult.class);
    }

    @RequestMapping("get/myService")
    public String getMyService(){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance instance = myLb.getInstance(instances);
        log.info(instance.getUri().toString());
        return restTemplate.getForObject(instance.getUri()+"/payment/lb",String.class);
    }
}
