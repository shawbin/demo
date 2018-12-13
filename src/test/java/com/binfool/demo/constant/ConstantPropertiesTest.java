package com.binfool.demo.constant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author bin
 * @date 2018/12/13 19:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ConstantPropertiesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstantPropertiesTest.class);

    @Autowired
    private ConstantProperties constantProperties;

    @Test
    public void getTest() {

        String test = constantProperties.getTest();
        LOGGER.info("test==>{}", test);
        assertEquals("test", test);
    }
}