package com.xh.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpTools {


    public static JSONObject getJson(String url){

        try {
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            CloseableHttpClient client = httpClientBuilder.build();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity, "utf-8");
            JSONObject jsonObject = JSONObject.parseObject(s);
            return  jsonObject;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject postJson(String url){
        try {
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            CloseableHttpClient client = httpClientBuilder.build();
            System.out.println(url);
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpResponse response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity, "utf-8");
            JSONObject jsonObject = JSONObject.parseObject(s);
            return  jsonObject;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
