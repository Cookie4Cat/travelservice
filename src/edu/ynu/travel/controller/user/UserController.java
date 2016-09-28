package edu.ynu.travel.controller.user;

import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.message.common.SimpleResponse;
import edu.ynu.travel.message.user.LoginMessage;
import edu.ynu.travel.message.user.RegistMessage;
import edu.ynu.travel.message.user.UserMessage;
import edu.ynu.travel.service.user.IUserService;
import edu.ynu.travel.util.MD5Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user/traveler")
public class UserController {

    @Resource
    private IUserService userService;


    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public SimpleResponse addUser(@RequestBody RegistMessage regist){
        String passwordHash = MD5Util.GetMD5Code(regist.getPassword());
        short status = (short)0;
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
