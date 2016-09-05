package edu.ynu.travel.service.complaint.impl;

import edu.ynu.travel.entity.complaint.UserEntity;
import edu.ynu.travel.mapper.complaint.UserEntityMapper;
import edu.ynu.travel.service.complaint.IUserService;
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
