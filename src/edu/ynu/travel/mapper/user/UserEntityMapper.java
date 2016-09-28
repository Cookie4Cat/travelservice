package edu.ynu.travel.mapper.user;

import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.message.user.UserMessage;
import org.springframework.stereotype.Repository;

@Repository("UserMapper")
public interface UserEntityMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteUserRoleByUId(int id);

    int insert(UserEntity record);


    int insertUserRole(int userId, int roleId);


    int insertSelective(UserEntity record);


    UserMessage selectByPrimaryKey(Integer id);


    UserEntity login(String usename, String password);


    int updateByPrimaryKeySelective(UserEntity record);


    int updateByPrimaryKey(UserEntity record);
}