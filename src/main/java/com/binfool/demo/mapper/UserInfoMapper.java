package com.binfool.demo.mapper;

import com.binfool.demo.domain.UserInfo;
import com.binfool.demo.domain.UserInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 用户信息表mapper
 * @author bin
 * @date 2018/12/12 17:09
 */
@Mapper
@Component
public interface UserInfoMapper extends BaseMapper<UserInfo, UserInfoExample>{
}