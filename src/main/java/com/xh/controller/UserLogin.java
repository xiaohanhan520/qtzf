package com.xh.controller;

import com.xh.entity.User;
import com.xh.service.user.UserService;
import com.xh.utils.IpAddressUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;


@Slf4j
@Controller
@RequestMapping("/manage")
public class UserLogin {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> userLogin(User user, HttpSession session, HttpServletRequest request){
        log.info("=====开始登陆=====");
        Map<String, Object> map = userService.queryUserLogin(user, request);
        if (map.get("code").equals(200)){
            log.info("登陆成功");
            return map;
        }else {
            session.setAttribute("message","用户名或密码错误");
            log.info("登陆失败");
            return map;
        }
    }

    @RequestMapping("/out")
    public String userOutLogin(HttpServletRequest request){
        userService.userOut(request);
        return "index";
    }

}
