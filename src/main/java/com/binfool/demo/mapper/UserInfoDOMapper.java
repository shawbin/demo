package com.binfool.demo.mapper;

import com.binfool.demo.DO.UserInfoDO;
import com.binfool.demo.DO.UserInfoDOExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表mapper
 * @author bin
 * @date 2018/12/12 17:09
 */
@Mapper
public interface UserInfoDOMapper extends BaseMapper<UserInfoDO, UserInfoDOExample>{
}