package com.crossing.controller;

import com.crossing.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Crossing
 * @Date 2020-07-15
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

  @Resource
  private PaymentHystrixService paymentHystrixService;


  @GetMapping("/consumer/payment/hystrix/ok/{id}")
  public String paymentInfoOK(@PathVariable("id") Integer id) {
    return paymentHystrixService.paymentInfoOK(id);
  }

  @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//  @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//  })
  @HystrixCommand
  public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
    int age = 10 / 0;
    String result = paymentHystrixService.paymentInfoTimeOut(id);
    return result;
  }

  public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
    return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
  }

  // 下面是全局fallback方法
  public String paymentGlobalFallbackMethod() {
    return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
  }

}
