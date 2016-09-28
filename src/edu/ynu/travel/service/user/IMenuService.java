package edu.ynu.travel.service.user;


import edu.ynu.travel.entity.user.MenuEntity;
import edu.ynu.travel.message.user.MenuList;

import java.util.List;


public interface IMenuService {
    MenuEntity getMenuById(int id);
    List<MenuEntity> listAll();
    MenuList listAll(int page, int size);
    List<MenuEntity> getMenuByUId(int id);
    int addMenu(MenuEntity menuEntity);
    int updateMenu(MenuEntity menuEntity);
    int deleteMenu(int id);
}
