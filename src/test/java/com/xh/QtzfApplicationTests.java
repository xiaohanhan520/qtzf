package com.xh;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xh.dao.LoginLogDao;
import com.xh.dao.UserDao;
import com.xh.entity.LoginLog;
import com.xh.entity.User;
import com.xh.utils.Md5Util;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QtzfApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    LoginLogDao loginLogDao;

    @Test
    public void contextLoads() throws IOException {
        LoginLog loginLog = new LoginLog();
        String uid = Md5Util.getUid();
        loginLogDao.insert(loginLog.setId(uid).setLoginName("222").setLoginIp("0000").setStatus("卧槽无情"));




    }

}
