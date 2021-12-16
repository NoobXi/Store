package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import com.example.user.service.ex.EmailDuplicatedException;
import com.example.user.service.ex.InsertException;
import com.example.user.service.ex.UsernameDuplicatedException;
import com.example.user.util.JsonResult;
import com.example.user.util.LoginResult;
import com.sun.source.tree.ReturnTree;
import org.apache.ibatis.jdbc.Null;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Noob
 * @date 2021/12/13 - 20:44
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
 public JsonResult<Void> reg(User user){
        JsonResult<Void> result  =new JsonResult<>();
        try {
            userService.register(user);
            result.setState(200);
            result.setMessage("用户注册成功");
        }catch (UsernameDuplicatedException e){
            result.setState(4000);
            result.setMessage("账号被占用");
        }catch (InsertException e){
            result.setState(5000);
            result.setMessage("未知错误");
        }catch (EmailDuplicatedException e){
        result.setState(600);
        result.setMessage("邮箱被占用");
        }
        return result;
    }

    //登录
    @RequestMapping("/login")
    public Object login(User param, HttpSession session) {
        User user=userService.login(param);
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("userInfo",user);
            return LoginResult.success("登录成功");
        }
        return LoginResult.fail("用户名或密码错误!");
    }



    //忘记密码
    @RequestMapping("/forget")
    public Object forget(User param){
        User user = userService.forget(param);
    if(user.getAccount()!=null){
        return LoginResult.success("输入密保");
    }
    if(user.getEmail()!=null){
        return LoginResult.success("输入密保");
    }
        return LoginResult.fail("账号或邮箱不存在");
    }

}
