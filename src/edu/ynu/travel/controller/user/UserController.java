package edu.ynu.travel.controller.user;

import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.service.user.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable int id){
        UserEntity userEntity = userService.getUser(id);
        return userEntity;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public int addUser(@RequestBody UserEntity user){
        int id = userService.addUser(user);
        return id;
    }
}
