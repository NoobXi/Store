package com.example.user.service.impl;

import com.example.user.entity.User;
import com.example.user.mapper.UserMapper;
import com.example.user.service.UserService;
import com.example.user.service.ex.EmailDuplicatedException;
import com.example.user.service.ex.InsertException;
import com.example.user.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Noob
 * @date 2021/12/13 - 20:36
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        //注册的邮箱
        //与查询出来的邮箱对比
        //是否相同对比
        String email= user.getEmail();
        User e1 = userMapper.findEmail(email);

        //获取注册的账号
        String username=user.getAccount();
        //与查询出来的账号对比
        //是否相同对比
        User result = userMapper.findByUsername(username);
        if(result!=null){
            throw new UsernameDuplicatedException("用户名被占用");
        }
        if(e1!=null){
            throw new EmailDuplicatedException("邮箱被占用");
        }
        //设置用户的权限为0
        user.setPermission(0);

        Integer rows = userMapper.insert(user);
        if(rows!= 1){
            throw new InsertException("未知异常");
        }
    }


    //登录
    @Override
    public User login(User user) {
    return userMapper.getUser(user);
    }

    //忘记密码
    @Override
    public User forget(User user) {
        return  userMapper.findDetail(user);
    }




}
