package com.crossing.controller;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Crossing
 * @Date 2020-07-12
 */
@RestController
@Slf4j
public class OrderConsulController {

  public static final String INVOKE_URL = "http://provider-payment";

  @Resource
  RestTemplate restTemplate;

  @GetMapping("/consumer/payment/consul")
  public String paymentInfo() {
    return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
  }

}
