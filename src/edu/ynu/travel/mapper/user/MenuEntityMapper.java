package edu.ynu.travel.mapper.user;

import edu.ynu.travel.entity.user.MenuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MenuMapper")
public interface MenuEntityMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(MenuEntity record);


    int insertSelective(MenuEntity record);


    MenuEntity selectByPrimaryKey(Integer id);


    List<MenuEntity> selectByRoleId(Integer id);


    List<MenuEntity> selectAll();


    int updateByPrimaryKeySelective(MenuEntity record);


    int updateByPrimaryKey(MenuEntity record);
}