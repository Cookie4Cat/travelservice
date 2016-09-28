package edu.ynu.travel.mapper.user;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import edu.ynu.travel.entity.user.MenuEntity;
import edu.ynu.travel.message.user.MenuList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MenuMapper")
public interface MenuEntityMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(MenuEntity record);


    int insertSelective(MenuEntity record);


    MenuEntity selectByPrimaryKey(Integer id);


    List<MenuEntity> selectByRoleId(Integer id);


    List<MenuEntity> selectByUserId(Integer id);


    List<MenuEntity> selectAll();

    List<MenuEntity> selectAll(PageBounds pageBounds);

    int updateByPrimaryKeySelective(MenuEntity record);


    int updateByPrimaryKey(MenuEntity record);
}