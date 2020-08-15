package com.crossing.controller;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Crossing
 * @Date 2020-07-12
 */
@RestController
@Slf4j
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  @RequestMapping("/payment/consul")
  public String paymentConsul() {
    return "springCloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
  }

}
