package com.xh.controller;

import com.alibaba.fastjson.JSONObject;
import com.xh.utils.HttpTools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("tool")
public class ToolController {

    private final static String uid = "11119";

    /**
     *
     * @param url
     * @return 长网址转换成短网址
     */
    @RequestMapping("shortUrl")
    @ResponseBody
    public Object shortUrl(String url){
        String s = "http://surl.ylapi.cn/surl/create.u?uid=11119&appkey=d0d673787e7013a169b528e04dfe7a10&url="+url;
        JSONObject jsonObject = HttpTools.postJson(s);
        return jsonObject;
    }

    /**
     * 身份证查询
     */
    @ResponseBody
    @RequestMapping("idCard")
    public Object idCard(String card){
        String url = "http://cb.ylapi.cn/cookbook/query.u?uid=11119&appkey=38b1c80c7456ddb82e14e70c7f308118";
        JSONObject jsonObject = HttpTools.postJson(url);
        return jsonObject;
    }

    /**
     * 医院
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("hospital")
    public Object hospital(String provinceName, String cityName){
        String url = "http://hosp.ylapi.cn/hospital/search.u?uid=11119&appkey=38b1c80c7456ddb82e14e70c7f308118&provinceName="+provinceName+"&cityName="+cityName;
        JSONObject jsonObject = HttpTools.postJson(url);
        return jsonObject;
    }




    /**
     * 老黄历测凶吉
     * @return
     */
    @RequestMapping("lucky")
    @ResponseBody
    public Object lucky(String data){
        JSONObject jsonObject = HttpTools.postJson("http://lucky.ylapi.cn/lucky/query.u?uid=11119&appkey=be2f50d2e581a3c7b0e44dc291b2c6e6&date=" + data);
        return jsonObject;
    }

    /**
     * 历史上的今天
     *
     */
    @ResponseBody
    @RequestMapping("todayHis")
    public Object todayHis(String data){
        JSONObject jsonObject = HttpTools.postJson("http://dh.ylapi.cn/today_his/query.u?uid=11119&appkey=c4dc90238fd6570b2bf23044bb9cef8a&date=" + data);
        return jsonObject;
    }




















}
