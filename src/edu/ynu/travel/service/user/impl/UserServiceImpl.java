package edu.ynu.travel.service.user.impl;

import edu.ynu.travel.entity.user.RoleEntity;
import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.mapper.user.RoleEntityMapper;
import edu.ynu.travel.mapper.user.UserEntityMapper;
import edu.ynu.travel.message.user.UserMessage;
import edu.ynu.travel.service.user.IUserService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource(name = "UserMapper")
    private UserEntityMapper userEntityMapper;
    @Resource(name = "RoleMapper")
    private RoleEntityMapper roleEntityMapper;

    @Override
    public UserMessage getUser(Integer id) {
        UserMessage userMessage = userEntityMapper.selectByPrimaryKey(id);
        List<RoleEntity> roles = roleEntityMapper.selectByUserId(id);
        userMessage.setRoles(roles);
        return userMessage;
    }

    @Override
    public int addUser(UserEntity record) {
        return userEntityMapper.insertSelective(record);
    }
}
