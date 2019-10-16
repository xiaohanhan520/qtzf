package com.xh.service;

import com.xh.entity.User;

import java.util.Map;


public interface UserService {

    public Map<String , Object> queryUserLogin(User user);

    public void userOut();
}
