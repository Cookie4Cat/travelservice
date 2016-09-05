package edu.ynu.travel.service.impl;

import edu.ynu.travel.entity.UserEntity;
import edu.ynu.travel.mapper.UserEntityMapper;
import edu.ynu.travel.service.IUserService;
import org.jvnet.hk2.annotations.Service;


import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/4.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource(name = "userEntityMapper")
    private UserEntityMapper userEntityMapper;

    @Override
    public UserEntity getUser(Integer id) {
        return userEntityMapper.selectByPrimaryKey(id);
    }
}
