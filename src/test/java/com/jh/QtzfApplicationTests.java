package com.jh;

import com.jh.dao.UserDao;
import com.jh.entity.User;
import com.jh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QtzfApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User admin = userDao.selectByUsername("admin");
        System.out.println(admin);
    }


}
