package com.crossing.service;

import org.springframework.stereotype.Component;

/**
 * @author Crossing
 * @Date 2020-07-15
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

  @Override
  public String paymentInfoOK(Integer id) {
    return "-----PaymentFallbackService fall back-paymentInfoOK ,o(╥﹏╥)o";
  }

  @Override
  public String paymentInfoTimeOut(Integer id) {
    return "-----PaymentFallbackService fall back-paymentInfoTimeOut ,o(╥﹏╥)o";
  }
}
