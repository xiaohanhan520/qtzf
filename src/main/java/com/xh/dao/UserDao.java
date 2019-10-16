package com.xh.dao;

import com.xh.entity.User;

public interface UserDao {

    public User selectByUsername(String name);
}
