package com.jh.dao;

import com.jh.entity.User;

public interface UserDao {

    public User selectByUsername(String name);
}
