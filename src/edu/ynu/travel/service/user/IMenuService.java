package edu.ynu.travel.service.user;


import edu.ynu.travel.entity.user.MenuEntity;

import java.util.List;


public interface IMenuService {
    MenuEntity getMenuById(int id);
    List<MenuEntity> listAll();
    int addMenu(MenuEntity menuEntity);
    int updateMenu(MenuEntity menuEntity);
    int deleteMenu(int id);
}
