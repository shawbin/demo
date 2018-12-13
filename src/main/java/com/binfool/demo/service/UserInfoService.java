package com.binfool.demo.service;

import com.binfool.demo.DO.UserInfoDO;

/**
 * 用户信息service
 * @author bin
 * @date 2018/12/12 17:15
 */
public interface UserInfoService {

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    UserInfoDO selectByPrimaryKey(Long id);
}
