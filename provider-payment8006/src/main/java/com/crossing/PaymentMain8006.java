package com.crossing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Crossing
 * @Date 2020-07-12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8006.class, args);
  }

}
