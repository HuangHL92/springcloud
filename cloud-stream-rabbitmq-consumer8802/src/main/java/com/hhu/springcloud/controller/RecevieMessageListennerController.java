package com.hhu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/8/4
 * @version: 1.0
 */
@Component
@EnableBinding(Sink.class)
public class RecevieMessageListennerController {
    @Value("${server.port}")
    private  String serverPort;
    @StreamListener(Sink.INPUT)
    public void input(Message message){
         System.out.println("消费者1号，----->接收到的消息："+message.getPayload()+"\t port:"+serverPort);
    }

}
