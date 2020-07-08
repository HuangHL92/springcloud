package com.hhu.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/7/7
 * @version: 1.0
 */
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(value = "cloud-hystrix-payment-service",fallback = OrderHystriFallbackService.class)
public interface OrderHystrixService {


    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
