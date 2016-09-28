package edu.ynu.travel.service.user.impl;

import edu.ynu.travel.entity.user.RoleEntity;
import edu.ynu.travel.mapper.user.RoleEntityMapper;
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

    @Override
    public RoleEntity getRoleById(int id) {
        return roleEntityMapper.selectByPrimaryKey(id);
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
    public int deleteRoleById(int id) {
        return roleEntityMapper.deleteByPrimaryKey(id);
    }
}
