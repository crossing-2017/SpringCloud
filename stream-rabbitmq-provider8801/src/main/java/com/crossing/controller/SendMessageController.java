package com.crossing.controller;

import com.crossing.service.MessageProvider;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Crossing
 * @Date 2020-07-17
 */
@RestController
public class SendMessageController {

  @Resource
  private MessageProvider messageProvider;

  @GetMapping(value = "/sendMessage")
  public String sendMessage() {
    return messageProvider.send();
  }

}
