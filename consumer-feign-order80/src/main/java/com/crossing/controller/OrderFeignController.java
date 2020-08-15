package com.crossing.controller;

import com.crossing.service.PaymentFeignService;
import com.crossing.entity.CommonResult;
import com.crossing.entity.Payment;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Crossing
 * @Date 2020-07-15
 */
@RestController
@Slf4j
public class OrderFeignController {

  @Resource
  private PaymentFeignService paymentFeignService;


  @GetMapping(value = "/consumer/payment/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
    return paymentFeignService.getPaymentById(id);
  }

  @GetMapping(value = "/consumer/payment/feign/timeout")
  public String paymentFeignTimeout() {
    // OpenFeign客户端一般默认等待1秒钟
    return paymentFeignService.paymentFeignTimeout();
  }
}
