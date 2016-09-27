package edu.ynu.travel.controller.user;

import edu.ynu.travel.entity.user.RoleEntity;
import edu.ynu.travel.message.user.UserMessage;
import edu.ynu.travel.service.user.IRoleService;
import edu.ynu.travel.service.user.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/user/superAdmin")
public class SuperAdminController{
    @Resource
    private IUserService userService;
    @Resource
    private IRoleService roleService;

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public UserMessage getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public int addRole(@RequestBody RoleEntity roleEntity){
        return roleService.addRole(roleEntity);
    }

    @RequestMapping(value = "/roles/{id}/delete", method = RequestMethod.POST)
    public int deleteRole(@PathVariable int id){
        return roleService.deleteRoleById(id);
    }
}
