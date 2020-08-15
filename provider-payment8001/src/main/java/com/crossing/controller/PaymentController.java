package com.crossing.controller;

import com.crossing.entity.CommonResult;
import com.crossing.entity.Payment;
import com.crossing.service.PaymentService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Crossing
 * @Date 2020-07-11
 */
@RestController
@Slf4j
public class PaymentController {

  @Resource
  PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @Resource
  DiscoveryClient discoveryClient;

  @PostMapping("/payment/create")
  public CommonResult create(@RequestBody Payment payment) {
    int result = paymentService.create(payment);
    log.info("*****插入结果：" + result);
    if (result > 0) {
      return new CommonResult(200, "插入数据库成功, serverPort: " + serverPort, result);
    } else {
      return new CommonResult(404, "插入数据库失败", null);
    }
  }

  @GetMapping("/payment/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("*****插入结果：" + payment);
    if (payment != null) {
      return new CommonResult(200, "查询成功, serverPort: " + serverPort, payment);
    } else {
      return new CommonResult(404, "没有对应记录,查询ID: " + id, null);
    }
  }

  @GetMapping("/payment/discovery")
  public Object discovery() {
    List<String> clientServices = discoveryClient.getServices();
    for (String clientService : clientServices) {
      log.info("*****element: " + clientService);
    }

    List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");

    for (ServiceInstance instance : instances) {
      log.info(
          instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t"
              + instance.getUri());
    }
    return this.discoveryClient;
  }

  @GetMapping(value = "/payment/lb")
  public String getPaymentLB() {
    return serverPort;
  }

  @GetMapping(value = "/payment/feign/timeout")
  public String paymentFeignTimeout() {
    // 业务逻辑处理正确，但是需要耗费3秒钟
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return serverPort;
  }

  @GetMapping("/payment/zipkin")
  public String paymentZipkin() {
    return "Hi ,I'am payment zipkin server fall back，welcome to crossing，O(∩_∩)O哈哈~";
  }
}
