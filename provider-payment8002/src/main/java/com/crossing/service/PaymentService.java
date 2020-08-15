package com.crossing.service;

import com.crossing.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Crossing
 * @Date 2020-07-11
 */
public interface PaymentService {

  public int create(Payment payment);


  public Payment getPaymentById(@Param("id") Long id);

}
