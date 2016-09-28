package edu.ynu.travel.service.user;


import edu.ynu.travel.entity.user.RoleEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.user.RoleMessage;

import java.util.List;


public interface IRoleService {
    RoleMessage getRoleById(int id);
    List<RoleEntity> listAllRole();
    int addRole(RoleEntity roleEntity);
    SimpleResponse addRoleMenu(RoleMessage roleMessage);
    int deleteRoleById(int id);
}
