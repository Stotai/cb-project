package com.qianya.util.dtree.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/** 树类*/
@Data
public class EleTree {
  /** 节点ID*/
  private String id;
  /** 上级节点ID*/
  private String parentId;
  /** 节点名称*/
  private String title;
  /** 子节点集合*/
  private List<EleTree> children = new ArrayList<EleTree>();
  //省略了get、set、toString方法
}