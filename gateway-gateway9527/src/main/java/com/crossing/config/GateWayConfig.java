package com.crossing.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Crossing
 * @Date 2020-07-17
 */
@Configuration
public class GateWayConfig {

  @Bean
  public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
    Builder routes = routeLocatorBuilder.routes();
    routes.route("path_route_crossing", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
        .build();
    return routes.build();
  }

}
