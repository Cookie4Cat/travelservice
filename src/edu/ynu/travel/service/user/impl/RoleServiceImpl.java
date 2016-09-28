package edu.ynu.travel.service.user.impl;

import edu.ynu.travel.entity.user.MenuEntity;
import edu.ynu.travel.entity.user.RoleEntity;
import edu.ynu.travel.mapper.user.MenuEntityMapper;
import edu.ynu.travel.mapper.user.RoleEntityMapper;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.user.RoleMessage;
import edu.ynu.travel.service.user.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

    @Resource(name = "RoleMapper")
    private RoleEntityMapper roleEntityMapper;
    @Resource(name = "MenuMapper")
    private MenuEntityMapper menuEntityMapper;

    @Override
    public RoleMessage getRoleById(int id) {
        RoleMessage role = roleEntityMapper.selectRoleById(id);
        List<MenuEntity> menus = menuEntityMapper.selectByRoleId(id);
        role.setMenus(menus);
        return role;
    }

    @Override
    public List<RoleEntity> listAllRole() {
        return roleEntityMapper.selectAll();
    }

    @Override
    public int addRole(RoleEntity roleEntity) {
        return roleEntityMapper.insert(roleEntity);
    }

    @Override
    public SimpleResponse addRoleMenu(RoleMessage roleMessage) {
        int roleId = roleMessage.getId();
        List<MenuEntity> menus = roleMessage.getMenus();
        for (MenuEntity menu: menus) {
            int menuId = menu.getId();
            roleEntityMapper.insertRoleMenu(roleId,menuId);
        }
        return new SimpleResponse("菜单成功添加","success");
    }

    @Override
    public int deleteRoleById(int id) {
        return roleEntityMapper.deleteByPrimaryKey(id);
    }
}
