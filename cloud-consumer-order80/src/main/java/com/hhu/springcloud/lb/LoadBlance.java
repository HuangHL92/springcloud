package com.hhu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBlance {
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances);
}
