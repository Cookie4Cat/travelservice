package edu.ynu.travel.mapper;

import edu.ynu.travel.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository("userEntityMapper")
public interface UserEntityMapper {

    int deleteByPrimaryKey(Integer customerId);


    int insert(UserEntity record);


    int insertSelective(UserEntity record);


    UserEntity selectByPrimaryKey(Integer customerId);


    int updateByPrimaryKeySelective(UserEntity record);


    int updateByPrimaryKey(UserEntity record);
}