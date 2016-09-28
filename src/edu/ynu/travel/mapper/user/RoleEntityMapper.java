package edu.ynu.travel.mapper.user;

import edu.ynu.travel.entity.user.RoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("RoleMapper")
public interface RoleEntityMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(RoleEntity record);


    int insertSelective(RoleEntity record);


    List<RoleEntity> selectByUserId(Integer id);


    List<RoleEntity> selectAll();


    RoleEntity selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(RoleEntity record);


    int updateByPrimaryKeyWithBLOBs(RoleEntity record);


    int updateByPrimaryKey(RoleEntity record);
}