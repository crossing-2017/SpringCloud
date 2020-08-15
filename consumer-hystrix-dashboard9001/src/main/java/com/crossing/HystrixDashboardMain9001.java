package com.crossing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Crossing
 * @Date 2020-07-15
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

  public static void main(String[] args) {
    SpringApplication.run(HystrixDashboardMain9001.class, args);
  }

}
