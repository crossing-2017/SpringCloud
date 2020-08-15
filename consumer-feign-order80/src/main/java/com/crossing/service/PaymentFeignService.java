package com.crossing.service;

import com.crossing.entity.CommonResult;
import com.crossing.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Crossing
 * @Date 2020-07-15
 */
@Component
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignService {

  @GetMapping("/payment/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

  @GetMapping("/payment/feign/timeout")
  public String paymentFeignTimeout();

}
