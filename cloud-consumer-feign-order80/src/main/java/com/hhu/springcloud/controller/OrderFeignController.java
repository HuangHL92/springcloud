package com.hhu.springcloud.controller;

import com.hhu.springcloud.entities.CommonResult;
import com.hhu.springcloud.entities.Payment;
import com.hhu.springcloud.service.OrderFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/7/3
 * @version: 1.0
 */
@Controller
public class OrderFeignController {
    @Resource
    OrderFeignService orderFeignService;
    @ResponseBody
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id){

    return orderFeignService.getPaymentById(id);
    }

}
