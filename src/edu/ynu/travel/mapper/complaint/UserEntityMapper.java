package edu.ynu.travel.mapper.complaint;

import edu.ynu.travel.entity.complaint.UserEntity;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserEntityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}