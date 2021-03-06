package com.crossing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Crossing
 * @Date 2020-07-18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain83 {

  public static void main(String[] args) {
    SpringApplication.run(OrderNacosMain83.class, args);
  }


}
