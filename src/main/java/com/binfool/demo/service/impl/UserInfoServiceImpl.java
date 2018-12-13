package com.binfool.demo.service.impl;

import com.binfool.demo.DO.UserInfoDO;
import com.binfool.demo.constant.DBTypeEnum;
import com.binfool.demo.framework.SetDataSource;
import com.binfool.demo.mapper.UserInfoDOMapper;
import com.binfool.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserInfoService
 * @author bin
 * @date 2018/12/12 17:11
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDOMapper userInfoDOMapper;

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @SetDataSource(value = DBTypeEnum.SLAVE)
    @Override
    public UserInfoDO selectByPrimaryKey(Long id) {
        return userInfoDOMapper.selectByPrimaryKey(id);
    }
}
