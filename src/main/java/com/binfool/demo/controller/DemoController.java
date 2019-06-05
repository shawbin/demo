package com.binfool.demo.controller;

import com.binfool.demo.domain.UserInfo;
import com.binfool.demo.service.DemoService;
import com.binfool.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试controller
 * @author bin
 * @date 2018/12/11 21:56
 */
@Controller
@RequestMapping(value = "/user")
public class DemoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/index")
    public String index(){
        return "home";
    }

    @ResponseBody
    @GetMapping(value = "/getUserInfo/{id}")
    public UserInfo getUserInfo(@PathVariable("id") Long id){
        return userInfoService.selectByPrimaryKey(id);
    }

    @ResponseBody
    @GetMapping(value = "/test/rabbitmq/send")
    public String testRabbitmq(){
        return demoService.testRabbitmq();
    }

}
