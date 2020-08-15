package com.crosssing.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Crossing
 * @Date 2020-07-18
 */
@RestController
@Slf4j
public class FlowLimitController {

  @GetMapping("/testA")
  public String testA() {
    return "------testA";
  }

  @GetMapping("/testB")
  public String testB() {
    log.info(Thread.currentThread().getName() + "\t" + "...testB");
    return "------testB";
  }

  @GetMapping("/testD")
  public String testD() {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("testD 测试RT");

//    log.info("testD 异常比例");
//    int age = 10 / 0;
    return "------testD";
  }

  @GetMapping("/testE")
  public String testE() {
    log.info("testE 测试异常数");
    int age = 10 / 0;
    return "------testE 测试异常数";
  }

  @GetMapping("/testHotKey")
  @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
  public String testHotKey(
      @RequestParam(value = "p1", required = false) String p1,
      @RequestParam(value = "p2", required = false) String p2) {
//    int age = 10 / 0;
    return "------testHotKey";
  }

  public String dealTestHotKey(String p1, String p2, BlockException exception) {
    return "------dealTestHotKey,o(╥﹏╥)o";  //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
  }

}