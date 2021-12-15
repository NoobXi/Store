package com.example.user.service;

import com.example.user.entity.User;


/**
 * @author Noob
 * @date 2021/12/13 - 20:34
 */

public interface UserService {
    //注册
    void register(User user);

    //登录
    public User login(User user);
}
