package com.hhu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/7/31
 * @version: 1.0
 */
@Controller
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/config/info")
    @ResponseBody
    public String GetConfigMessage(){
        return info;
    }

}