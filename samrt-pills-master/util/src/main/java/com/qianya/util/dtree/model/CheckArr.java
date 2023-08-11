package com.qianya.util.dtree.model;

import lombok.Data;

@Data
public class CheckArr {
  /** 复选框标记*/
  private String type;
  /** 复选框是否选中*/
  private String checked;
  
  //省略了get、set、toString方法
}