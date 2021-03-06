package com.example.user.mapper;

import com.example.user.entity.User;
import org.springframework.stereotype.Repository;


/**
 * @author Noob
 * @date 2021/12/13 - 19:32
 */
@Repository
public interface UserMapper {
    /*
    * 插入用户的数据
    * @param user 用户的数据
    * @return 受影响的行数
    * */
    Integer insert(User user);

    /*
    * 根据用户名来查询用户的数据
    * account用户名
    * */
    User findByUsername(String account);

    //登录
    User getUser(User user);

    //找邮箱
    User findEmail(String email);

    //找用户邮箱或者账号
    User findDetail(User user);


}
