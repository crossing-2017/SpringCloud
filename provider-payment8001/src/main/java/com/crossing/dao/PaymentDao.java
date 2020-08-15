package com.crossing.dao;

import com.crossing.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Crossing
 * @Date 2020-07-11
 */
@Mapper
public interface PaymentDao {

  public int create(Payment payment);


  public Payment getPaymentById(@Param("id") Long id);

}
