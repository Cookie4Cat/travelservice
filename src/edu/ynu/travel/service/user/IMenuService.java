package edu.ynu.travel.service.user;


import edu.ynu.travel.entity.user.MenuEntity;


public interface IMenuService {
    MenuEntity getMenuById(int id);
    int addMenu(MenuEntity menuEntity);
    int updateMenu(MenuEntity menuEntity);
    int deleteMenu(int id);
}
