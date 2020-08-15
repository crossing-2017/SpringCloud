package com.crossing.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Crossing
 * @Date 2020-07-15
 */
@FeignClient(value = "PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
@Component
public interface PaymentHystrixService {

  @GetMapping("/payment/hystrix/ok/{id}")
  public String paymentInfoOK(@PathVariable("id") Integer id);

  @GetMapping("/payment/hystrix/timeout/{id}")
  public String paymentInfoTimeOut(@PathVariable("id") Integer id);

}
