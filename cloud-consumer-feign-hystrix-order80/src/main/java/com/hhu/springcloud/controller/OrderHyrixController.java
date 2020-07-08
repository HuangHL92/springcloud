package com.hhu.springcloud.controller;

import com.hhu.springcloud.service.OrderHystrixService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/7/7
 * @version: 1.0
 */
@Controller
public class OrderHyrixController {
    @Resource
    private OrderHystrixService orderHystrixService;

    @RequestMapping("payment/hyrix/ok/{id}")
    @ResponseBody
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return orderHystrixService.paymentInfo_OK(id);
    }

    @RequestMapping("payment/hyrix/timeout/{id}")
    @ResponseBody
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeHandLer",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    public String paymentInfo_TimeOut (@PathVariable("id") Integer id){
        return orderHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_TimeHandLer(@PathVariable Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

}
