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
        String url = "http://icard.ylapi.cn/id_card/query.u?uid=11119&appkey=a741d887c790e4dccbb046cc0c2f9fdc&idnumber="+card;
        JSONObject jsonObject = HttpTools.postJson(url);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("cookBook")
    public Object cookBook(String card){
        String url = "http://cb.ylapi.cn/cookbook/query.u?uid=11119&appkey=a741d887c790e4dccbb046cc0c2f9fdc&idnumber="+card;
        JSONObject jsonObject = HttpTools.postJson(url);
        return jsonObject;
    }

}
