package com.binfool.demo.controller;

import com.binfool.demo.DO.UserInfoDO;
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

    @GetMapping(value = "/index")
    public String index(){
        return "home";
    }

    @ResponseBody
    @GetMapping(value = "/getUserInfo/{id}")
    public UserInfoDO getUserInfo(@PathVariable("id") Long id){
        return userInfoService.selectByPrimaryKey(id);
    }
}
