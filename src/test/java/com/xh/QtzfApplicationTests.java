package com.xh;


import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QtzfApplicationTests {



    @Test
    public void contextLoads() {
        String s = UUID.randomUUID().toString();
        SimpleHash md5 = new SimpleHash("MD5", "123456", "23344", 1024);
        SimpleHash md2 = new SimpleHash("MD5", "123456", s, 1024);

        System.out.println(md5.toString().length());
        System.out.println(md2.toString().length());
    }

}
