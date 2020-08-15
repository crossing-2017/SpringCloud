package com.crossing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Crossing
 * @Date 2020-07-11
 */
@Configuration
public class ApplicationContextConfig {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
