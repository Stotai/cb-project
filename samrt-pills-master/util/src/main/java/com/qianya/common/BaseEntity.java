package com.qianya.common;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseEntity implements Serializable {
    @TableField(exist = false)
    @ApiModelProperty(value = "页数")
    private Integer pageNo;
    @TableField(exist = false)
    @ApiModelProperty(value = "行数")
    private Integer pageSize;
}
