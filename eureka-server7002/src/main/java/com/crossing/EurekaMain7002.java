package com.crossing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Crossing
 * @Date 2020-07-11
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7002 {

  public static void main(String[] args) {
    SpringApplication.run(EurekaMain7002.class, args);
  }

}
