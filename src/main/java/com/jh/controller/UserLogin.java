package com.jh.controller;

import com.jh.entity.User;
import com.jh.service.UserService;
import com.jh.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class UserLogin {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> userLogin(User user, HttpSession session){
        System.out.println("=====开始登陆=====");
        Map<String, Object> map = userService.queryUserLogin(user);
        if (map.get("code").equals(200)){
            System.out.println("登陆成功");
            return map;
        }else {
            session.setAttribute("message","用户名或密码错误");
            System.out.println("登陆失败");
            return map;
        }
    }

    @RequestMapping("/out")
    public void userOutLogin(){
        userService.userOut();
    }

}
