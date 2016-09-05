package edu.ynu.travel.controller;

import edu.ynu.travel.entity.UserEntity;
import edu.ynu.travel.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userServiceImpl;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public UserEntity selectByPrimaryKey(@PathVariable Integer id){
        UserEntity userEntity = userServiceImpl.getUser(id);
        return userEntity;
    }
}
