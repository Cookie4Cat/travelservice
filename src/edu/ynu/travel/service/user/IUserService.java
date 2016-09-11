package edu.ynu.travel.service.user;

import edu.ynu.travel.entity.user.UserEntity;

/**
 * Created by Administrator on 2016/9/4.
 */


public interface IUserService{
    UserEntity getUser(Integer id);
    int addUser(UserEntity record);
}
