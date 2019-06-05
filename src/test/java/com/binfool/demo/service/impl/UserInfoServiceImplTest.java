package com.binfool.demo.service.impl;

import com.binfool.demo.domain.UserInfo;
import com.binfool.demo.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author bin
 * @date 2018/12/12 21:41
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImplTest.class);

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void selectByPrimaryKey() {
        UserInfo userInfo = userInfoService.selectByPrimaryKey(1L);
        LOGGER.info("userInfo==>{}", userInfo.toString());
    }
}