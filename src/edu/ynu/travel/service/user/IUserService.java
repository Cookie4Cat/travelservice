package edu.ynu.travel.service.user;

import edu.ynu.travel.entity.user.UserEntity;




public interface IUserService{
    UserEntity getUser(Integer id);
    int addUser(UserEntity record);
}
