package com.crossing.lb;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

/**
 * @author Crossing
 * @Date 2020-07-15
 */
public interface LoadBalancer {

  ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
