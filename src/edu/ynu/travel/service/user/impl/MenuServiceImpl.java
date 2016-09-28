package edu.ynu.travel.service.user.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.user.MenuEntity;
import edu.ynu.travel.mapper.user.MenuEntityMapper;
import edu.ynu.travel.message.user.MenuList;
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
    public MenuList listAll(int page, int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        List<MenuEntity> menuEntities = menuEntityMapper.selectAll(pageBounds);
        PageList pageList = (PageList) menuEntities;
        int count = pageList.getPaginator().getTotalCount();
        return new MenuList(menuEntities,count);
    }

    @Override
    public List<MenuEntity> getMenuByUId(int id) {
        return menuEntityMapper.selectByUserId(id);
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
