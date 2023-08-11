package com.qianya.util.dtree.model;

import lombok.Data;

@Data
public class DTreeResponse {
  /** 状态码*/
  private int code;
  /** 信息标识*/
  private String msg;
  /** 状态类*/
  private Status status;
  /** 数据*/
  private Object data;
  
  //省略了get、set、toString方法
}