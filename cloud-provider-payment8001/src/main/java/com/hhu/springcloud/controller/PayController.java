package com.hhu.springcloud.controller;

import com.hhu.springcloud.entities.CommonResult;
import com.hhu.springcloud.entities.Payment;
import com.hhu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/6/23
 * @version: 1.0
 */
@Controller
@Slf4j
public class PayController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;
    @PostMapping("/payment/create")
    @ResponseBody
    public  CommonResult creat(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("插入结果{}",i);
        if(i>0){
            return new CommonResult(200,"插入成功,端口号为："+serverPort,i);
        }
        else{
            return  new CommonResult(444,"插入失败,端口号为："+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果为{}",paymentById);
        if(paymentById != null){
            return new CommonResult(200,"查询kkk成功，端口号为："+serverPort,paymentById);
        }
        else{
            return  new CommonResult(444,"查询失败，端口号为："+serverPort,null);
        }
    }
    
    @RequestMapping("/getResource")
    @ResponseBody
    public DiscoveryClient getResours(){
        List<String> services = discoveryClient.getServices();
        for (String service:services){
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
       for(ServiceInstance serviceInstance:instances){
           log.info(serviceInstance.getHost()+"\t"+serviceInstance.getUri()+"\t"+serviceInstance.getPort());
       }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    @ResponseBody
    public String getMyService(){

        return serverPort;
    }
}
