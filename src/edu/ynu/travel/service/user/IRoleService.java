package edu.ynu.travel.service.user;


import edu.ynu.travel.entity.user.RoleEntity;

import java.util.List;

public interface IRoleService {
    RoleEntity getRoleById(int id);
    int addRole(RoleEntity roleEntity);
    int deleteRoleById(int id);
}