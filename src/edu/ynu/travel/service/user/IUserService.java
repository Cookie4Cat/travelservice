package edu.ynu.travel.service.user;

import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.user.LoginMessage;
import edu.ynu.travel.message.user.UserList;
import edu.ynu.travel.message.user.UserMessage;

import java.util.List;


public interface IUserService{
    UserList getAdmin(int page, int size);
    UserMessage getUser(Integer id);
    SimpleResponse addUserRole(UserMessage userMessage);
    SimpleResponse addUser(UserEntity record);
    UserEntity login(String username, String password);
}
