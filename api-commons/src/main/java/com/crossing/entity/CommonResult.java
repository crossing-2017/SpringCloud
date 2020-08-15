package com.crossing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Crossing
 * @Date 2020-07-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

  //404 not_found
  private Integer code;
  private String msg;
  private T data;


  public CommonResult(Integer code, String msg) {
    this(code, msg, null);
  }

}
