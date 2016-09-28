package edu.ynu.travel.controller.user;

import edu.ynu.travel.entity.user.RoleEntity;
import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.user.LoginMessage;
import edu.ynu.travel.message.user.RegistMessage;
import edu.ynu.travel.message.user.RoleMessage;
import edu.ynu.travel.message.user.UserMessage;
import edu.ynu.travel.service.user.IRoleService;
import edu.ynu.travel.service.user.IUserService;
import edu.ynu.travel.util.MD5Util;
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

    @RequestMapping(value = "/roles/{id}",method = RequestMethod.GET)
    public RoleMessage getRole(@PathVariable int id){
        return roleService.getRoleById(id);
    }

    @RequestMapping(value = "/roles/menus", method = RequestMethod.POST)
    public SimpleResponse addRoleMenu(@RequestBody RoleMessage role){
        return roleService.addRoleMenu(role);
    }


    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public int addRole(@RequestBody RoleEntity roleEntity){
        return roleService.addRole(roleEntity);
    }

    @RequestMapping(value = "/roles/{id}/delete", method = RequestMethod.POST)
    public int deleteRole(@PathVariable int id){
        return roleService.deleteRoleById(id);
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public SimpleResponse addAdmin(@RequestBody RegistMessage regist){
        String passwordHash = MD5Util.GetMD5Code(regist.getPassword());
        short status = (short)10;
        UserEntity userInsert = new UserEntity();
        userInsert.setUsername(regist.getUsername());
        userInsert.setEmail(regist.getEmail());
        userInsert.setPasswordHash(passwordHash);
        userInsert.setStatus(status);
        return userService.addUser(userInsert);
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public UserEntity login(@RequestBody LoginMessage loginMessage){
        String username = loginMessage.getUsername();
        String password = MD5Util.GetMD5Code(loginMessage.getPassword());
        return userService.login(username,password);
    }
}
