package edu.ynu.travel.service.user.impl;

import edu.ynu.travel.entity.user.MenuEntity;
import edu.ynu.travel.mapper.user.MenuEntityMapper;
import edu.ynu.travel.service.user.IMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements IMenuService {
    @Resource(name = "MenuMapper")
    private MenuEntityMapper menuEntityMapper;

    @Override
    public int addMenu(MenuEntity menuEntity) {
        return menuEntityMapper.insert(menuEntity);
    }

    @Override
    public List<MenuEntity> listAll() {
        return menuEntityMapper.selectAll();
    }

    @Override
    public int deleteMenu(int id) {
        return menuEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public MenuEntity getMenuById(int id) {
        return menuEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateMenu(MenuEntity menuEntity) {
        return menuEntityMapper.updateByPrimaryKey(menuEntity);
    }
}
