package com.hhu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/7/8
 * @version: 1.0
 */
@Component
public class OrderHystriFallbackService implements OrderHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "ok降级";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "timeOut降级";
    }
}
