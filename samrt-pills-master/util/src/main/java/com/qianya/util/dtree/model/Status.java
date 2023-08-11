package com.qianya.util.dtree.model;

import lombok.Data;

/** 信息状态类*/
@Data
public class Status {
  /** 状态码*/
  private int code = 200;
  /** 信息标识*/
  private String message = "success";
  
  //省略了get、set、toString方法
}