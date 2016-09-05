package edu.ynu.travel.test;

import edu.ynu.travel.controller.UserController;
import edu.ynu.travel.entity.UserEntity;
import org.junit.Test;

/**
 * Created by Administrator on 2016/9/4.
 */
public class UserTest {
    @Test
    public void testGet(){
        UserController userController = new UserController();
        UserEntity userEntity = userController.selectByPrimaryKey(1);
        System.out.println(userEntity.getUsername());
    }
}
