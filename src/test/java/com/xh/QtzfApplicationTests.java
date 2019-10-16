package com.xh;


import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class QtzfApplicationTests {



    @Test
    public void contextLoads() {
        try {

            String url = "http://v.juhe.cn/historyWeather/weather?key=22180a4080c1b51f3d8daf4b0dbc81be&city_id=1157&weather_date=20191015";
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            CloseableHttpClient client = httpClientBuilder.build();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity, "utf-8");
            JSONObject jsonObject = JSONObject.parseObject(s);
            System.out.println(jsonObject);
            String result = jsonObject.get("result").toString();
            System.out.println(result);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
