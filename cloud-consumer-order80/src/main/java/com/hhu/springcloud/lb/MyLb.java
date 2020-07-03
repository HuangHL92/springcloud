package com.hhu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/7/2
 * @version: 1.0
 */
@Component
public class MyLb implements LoadBlance {
    AtomicInteger atomicInteger =new AtomicInteger(0);

    public final int getAndIncrement(){
       int current;
       int next;
       do {
           current = atomicInteger.get();
           next = current>= 2147483647?0:current+1;
       }while (!atomicInteger.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()%serviceInstances.size();
        ServiceInstance serviceInstance = serviceInstances.get(index);
        return serviceInstance;
    }
}
