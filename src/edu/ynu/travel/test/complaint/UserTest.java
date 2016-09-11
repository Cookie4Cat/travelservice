package edu.ynu.travel.test.complaint;


import edu.ynu.travel.entity.user.UserEntity;
import edu.ynu.travel.service.user.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/9/4.
 */
public class UserTest {
    private ApplicationContext cxt;
    private IUserService userService;
    @Before
    public void setCxt(){
        cxt = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        userService = (IUserService)cxt.getBean("IUserService");
    }
    @Test
    public void testGet(){
        UserEntity userEntity = userService.getUser(1);
        System.out.println(userEntity.getUsername());
    }
}
