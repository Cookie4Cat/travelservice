package edu.ynu.travel.service.user.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import edu.ynu.travel.entity.user.MenuEntity;
import edu.ynu.travel.entity.user.RoleEntity;
import edu.ynu.travel.mapper.user.MenuEntityMapper;
import edu.ynu.travel.mapper.user.RoleEntityMapper;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.user.RoleList;
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
    public RoleList listAllRole(int page, int size) {
        PageBounds pageBounds = new PageBounds(page,size);
        List<RoleEntity> roleEntities = roleEntityMapper.selectAll(pageBounds);
        PageList pageList = (PageList) roleEntities;
        int count = pageList.getPaginator().getTotalCount();
        return new RoleList(pageList,count);
    }

    @Override
    public RoleEntity addRole(RoleEntity roleEntity) {
        return roleEntityMapper.insert(roleEntity)==1?roleEntity:null;
    }

    @Override
    public SimpleResponse addRoleMenu(RoleMessage roleMessage) {
        int roleId = roleMessage.getId();
        roleEntityMapper.deleteRoleMenuByRId(roleId);
        List<MenuEntity> menus = roleMessage.getMenus();
        for (MenuEntity menu: menus) {
            int menuId = menu.getId();
            roleEntityMapper.insertRoleMenu(roleId,menuId);
        }
        return new SimpleResponse("菜单成功添加","success");
    }

    @Override
    public int updateRole(RoleEntity roleEntity) {
        return roleEntityMapper.updateByPrimaryKey(roleEntity);
    }

    @Override
    public int deleteRoleById(int id) {
        return roleEntityMapper.deleteByPrimaryKey(id);
    }
}
