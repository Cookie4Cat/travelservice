package edu.ynu.travel.mapper.user;

import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.message.user.UserMessage;
import org.springframework.stereotype.Repository;

@Repository("UserMapper")
public interface UserEntityMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(UserEntity record);


    int insertSelective(UserEntity record);


    UserMessage selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(UserEntity record);


    int updateByPrimaryKey(UserEntity record);
}