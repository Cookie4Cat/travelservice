package edu.ynu.travel.message.user;


import edu.ynu.travel.entity.user.MenuEntity;
import edu.ynu.travel.entity.user.RoleEntity;


import java.util.List;


public class RoleMessage extends RoleEntity{
    private List<MenuEntity> menus;

    public List<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }
}
