package edu.ynu.travel.service;

import edu.ynu.travel.entity.UserEntity;

/**
 * Created by Administrator on 2016/9/4.
 */


public interface IUserService{
    UserEntity getUser(Integer id);
}
