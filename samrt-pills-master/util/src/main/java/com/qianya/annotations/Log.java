package com.qianya.annotations;

import com.qianya.cbEnum.BusinessType;
import com.qianya.cbEnum.OperatorType;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String service() default "Unknown Service";

    BusinessType businessType() default BusinessType.OTHER;

    OperatorType operatorType() default OperatorType.MANAGE;

    boolean isSaveRequestData() default true;
}
