package com.binfool.demo.framework;

import com.binfool.demo.constant.DBTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义在方法上的数据源注解
 * @author bin
 * @date 2018/12/12 15:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SetDataSource {

    DBTypeEnum value() default DBTypeEnum.MASTER;
}
