package com.crossing.service.impl;

import com.crossing.dao.PaymentDao;
import com.crossing.entity.Payment;
import com.crossing.service.PaymentService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Crossing
 * @Date 2020-07-11
 */
@Service
public class PaymentServiceImpl implements PaymentService {

  @Resource
  PaymentDao paymentDao;

  @Override
  public int create(Payment payment) {
    return paymentDao.create(payment);
  }

  @Override
  public Payment getPaymentById(Long id) {
    return paymentDao.getPaymentById(id);
  }
}
