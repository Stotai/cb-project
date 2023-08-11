package com.qianya.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字典注解
 * @author LHL
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamDict {
	
	/**
	 * @Desc 字段名，param表可不填
	 * @return
	 * @author LHL
	 * @Date 2020年6月15日 上午11:34:52
	 */
    String value() default "";
    
    /**
     * @Desc 数据表 没有就默认是param表
     * @return
     * @author LHL
	 * @Date 2020年6月15日 上午11:34:52
     */
    String dictTable() default "";
}
