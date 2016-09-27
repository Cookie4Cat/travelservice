package edu.ynu.travel.service.user.impl;

import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.mapper.user.UserEntityMapper;
import edu.ynu.travel.service.user.IUserService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource(name = "UserMapper")
    private UserEntityMapper userEntityMapper;

    @Override
    public UserEntity getUser(Integer id) {
        return userEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addUser(UserEntity record) {
        return userEntityMapper.insertSelective(record);
    }
}
