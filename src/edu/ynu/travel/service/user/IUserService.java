package edu.ynu.travel.service.user;

import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.message.user.UserMessage;


public interface IUserService{
        UserMessage getUser(Integer id);
    int addUser(UserEntity record);
}
