package com.crosssing.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.crossing.entity.CommonResult;
import com.crossing.entity.Payment;
import com.crosssing.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Crossing
 * @Date 2020-07-18
 */
@RestController
public class RateLimitController {

  @GetMapping("/byResource")
  @SentinelResource(value = "byResource", blockHandler = "handleException")
  public CommonResult byResource() {
    return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
  }

  public CommonResult handleException(BlockException exception) {
    return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
  }

  @GetMapping("/rateLimit/byUrl")
  @SentinelResource(value = "byUrl")
  public CommonResult byUrl() {
    return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
  }

  //CustomerBlockHandler
  @GetMapping("/rateLimit/customerBlockHandler")
  @SentinelResource(value = "customerBlockHandler",
      blockHandlerClass = CustomerBlockHandler.class,
      blockHandler = "handlerException2")
  public CommonResult customerBlockHandler() {
    return new CommonResult(200, "按客戶自定义", new Payment(2020L, "serial003"));
  }

}