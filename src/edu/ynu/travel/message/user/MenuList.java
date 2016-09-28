package edu.ynu.travel.message.user;

import edu.ynu.travel.entity.user.MenuEntity;

import java.util.List;

public class MenuList {
    private List<MenuEntity> menuEntities;
    private  int count;

    public MenuList(List<MenuEntity> menuEntities, int count) {
        this.menuEntities = menuEntities;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MenuEntity> getMenuEntities() {
        return menuEntities;
    }

    public void setMenuEntities(List<MenuEntity> menuEntities) {
        this.menuEntities = menuEntities;
    }
}
