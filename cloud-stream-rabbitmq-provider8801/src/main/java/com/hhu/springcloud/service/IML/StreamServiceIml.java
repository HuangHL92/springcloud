package com.hhu.springcloud.service.IML;

import com.hhu.springcloud.service.StreamService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/8/4
 * @version: 1.0
 */
@EnableBinding(Source.class)
public class StreamServiceIml implements StreamService {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        return null;
    }

}
