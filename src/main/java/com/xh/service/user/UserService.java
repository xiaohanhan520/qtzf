package com.xh.service.user;

import com.xh.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public interface UserService {

    public Map<String , Object> queryUserLogin(User user, HttpServletRequest servletRequest);

    public void userOut(HttpServletRequest servletRequest);

    public void registerUser(User user,HttpServletRequest servletRequest);
}
