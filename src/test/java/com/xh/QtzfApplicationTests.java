package com.xh;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.dao.UserDao;
import com.xh.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QtzfApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void contextLoads() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username","admin");
        List<User> users = userDao.selectList(userQueryWrapper);
        users.forEach(System.out::println);

    }

}
