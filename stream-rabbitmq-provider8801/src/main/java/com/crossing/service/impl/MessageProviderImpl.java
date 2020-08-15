package com.crossing.service.impl;

import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import com.crossing.service.MessageProvider;

/**
 * @author Crossing
 * @Date 2020-07-17
 */
@EnableBinding(Source.class)  //定义消息的推送管道
public class MessageProviderImpl implements MessageProvider {

  @Resource
  private MessageChannel output;  // 消息发送管道

  @Override
  public String send() {

    String serial = UUID.randomUUID().toString();
    output.send(MessageBuilder.withPayload(serial).build());
    System.out.println("*****serial: " + serial);
    return null;
  }
}
