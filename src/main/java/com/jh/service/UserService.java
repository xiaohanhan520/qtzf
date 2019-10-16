package com.jh.service;

import com.jh.entity.User;

import java.util.Map;


public interface UserService {

    public Map<String , Object> queryUserLogin(User user);

    public void userOut();
}
