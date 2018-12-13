package com.binfool.demo.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义属性及常量
 * @author bin
 * @date 2018/12/11 23:58
 */
@Configuration
public class ConstantProperties {

    @Value("${spring.constants.test}")
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
