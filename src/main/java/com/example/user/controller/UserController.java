package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import com.example.user.service.ex.InsertException;
import com.example.user.service.ex.UsernameDuplicatedException;
import com.example.user.util.JsonResult;
import com.example.user.util.LoginResult;
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
            result.setMessage("被占用");
        }catch (InsertException e){
            result.setState(5000);
            result.setMessage("未知错误");
        }
        return result;
    }

    //登录
    @RequestMapping("/login")
    public Object login(User param, HttpSession session) {
        User user=userService.login(param);
        if(user!=null){
            user.setPassword(null);
            //session.setAttribute("userInfo",user);
            return LoginResult.success();
        }
        return LoginResult.fail("用户名或密码错误!");

    }
}
