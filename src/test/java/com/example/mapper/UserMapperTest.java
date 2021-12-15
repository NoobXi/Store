package com.example.mapper;


import com.example.user.entity.User;
import com.example.user.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Noob
 * @date 2021/12/13 - 19:57
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void insert(){
    User user=new User();
    user.setAccount("tom");
    user.setPassword("123");
    Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }
}
