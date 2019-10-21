package com.xh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xh.entity.User;

public interface UserDao extends BaseMapper<User> {

    public User selectByUsername(String name);
}
