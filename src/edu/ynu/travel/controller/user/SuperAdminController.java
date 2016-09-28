package edu.ynu.travel.controller.user;

import edu.ynu.travel.entity.user.MenuEntity;
import edu.ynu.travel.entity.user.RoleEntity;
import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.user.*;
import edu.ynu.travel.service.user.IMenuService;
import edu.ynu.travel.service.user.IRoleService;
import edu.ynu.travel.service.user.IUserService;
import edu.ynu.travel.util.MD5Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/user/super-admin")
public class SuperAdminController{
    @Resource
    private IUserService userService;
    @Resource
    private IRoleService roleService;
    @Resource
    private IMenuService menuService;


    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public UserList getUser(@RequestParam(name = "page") int page,
                            @RequestParam(name = "size") int size){
        return userService.getAdmin(page,size);
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public UserMessage getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/users/{id}/menus",method = RequestMethod.GET)
    public List<MenuEntity> getMenuByUId(@PathVariable int id){
        return menuService.getMenuByUId(id);
    }

    @RequestMapping(value = "/roles/{id}",method = RequestMethod.GET)
    public RoleMessage getRole(@PathVariable int id){
        return roleService.getRoleById(id);
    }

    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public RoleList getAllRole(@RequestParam(name = "page") int page,
                               @RequestParam(name = "size") int size){
        return roleService.listAllRole(page,size);
    }

    @RequestMapping(value = "/roles/menus", method = RequestMethod.POST)
    public SimpleResponse addRoleMenu(@RequestBody RoleMessage role){
        return roleService.addRoleMenu(role);
    }


    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public int addRole(@RequestBody RoleEntity roleEntity){
        return roleService.addRole(roleEntity);
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.POST)
    public int updateRole(@RequestBody RoleEntity roleEntity,@PathVariable int id){
        roleEntity.setId(id);
        return roleService.updateRole(roleEntity);
    }

    @RequestMapping(value = "/roles/{id}/delete", method = RequestMethod.POST)
    public int deleteRole(@PathVariable int id){
        return roleService.deleteRoleById(id);
    }



    @RequestMapping(value = "/menus/{id}",method = RequestMethod.GET)
    public MenuEntity getMenu(@PathVariable int id){
        return menuService.getMenuById(id);
    }

    @RequestMapping(value = "/menus",method = RequestMethod.GET)
    public MenuList getAllMenu(@RequestParam(name = "page") int page,
                                 @RequestParam(name = "size") int size){
        return menuService.listAll(page,size);
    }

    @RequestMapping(value = "/menus", method = RequestMethod.POST)
    public int addMenu(@RequestBody MenuEntity menuEntity){
        return menuService.addMenu(menuEntity);
    }

    @RequestMapping(value = "/menus/{id}", method = RequestMethod.POST)
    public int updateMenu(@RequestBody MenuEntity menuEntity,@PathVariable int id){
        menuEntity.setId(id);
        return menuService.updateMenu(menuEntity);
    }

    @RequestMapping(value = "/menus/{id}/delete", method = RequestMethod.POST)
    public int deleteMenu(@PathVariable int id){
        return menuService.deleteMenu(id);
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public SimpleResponse addAdmin(@RequestBody RegistMessage regist){
        String passwordHash = MD5Util.GetMD5Code(regist.getPassword());
        short status = 1;
        UserEntity userInsert = new UserEntity();
        userInsert.setUsername(regist.getUsername());
        userInsert.setEmail(regist.getEmail());
        userInsert.setPasswordHash(passwordHash);
        userInsert.setStatus(status);
        return userService.addUser(userInsert);
    }

    @RequestMapping(value = "/users/roles",method = RequestMethod.POST)
    public  SimpleResponse addUserRole(@RequestBody UserMessage user){
        return userService.addUserRole(user);
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public UserEntity login(@RequestBody LoginMessage loginMessage){
        String username = loginMessage.getUsername();
        String password = MD5Util.GetMD5Code(loginMessage.getPassword());
        return userService.login(username,password);
    }
}
