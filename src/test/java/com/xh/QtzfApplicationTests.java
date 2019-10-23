package com.xh;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.dao.UserDao;
import com.xh.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QtzfApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
        String s = UUID.randomUUID().toString();


        System.out.println(s.length());

    }

}
