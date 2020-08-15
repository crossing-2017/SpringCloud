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
public class OrderZKMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderZKMain80.class, args);
  }

}
