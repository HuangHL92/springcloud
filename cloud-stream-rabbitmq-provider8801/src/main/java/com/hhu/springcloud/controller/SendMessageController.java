package com.hhu.springcloud.controller;

import com.hhu.springcloud.service.StreamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/8/4
 * @version: 1.0
 */
@Controller
public class SendMessageController {
     @Resource
    private StreamService streamService;

     @GetMapping(value = "/sendMessage")
     @ResponseBody
     public String sendMessage(){
         return streamService.send();
     }

}

