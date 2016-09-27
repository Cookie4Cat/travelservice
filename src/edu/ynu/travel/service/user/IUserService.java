package edu.ynu.travel.service.user;

import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.user.LoginMessage;
import edu.ynu.travel.message.user.UserMessage;


public interface IUserService{
    UserMessage getUser(Integer id);
    SimpleResponse addUser(UserEntity record);
    UserEntity login(String username, String password);
}
