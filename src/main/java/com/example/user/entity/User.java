package com.example.user.entity;

import lombok.Data;

/**
 * @author Noob
 * @date 2021/12/13 - 19:27
 */
@Data
public class User {
    private int id;
    private String account;
    private String password;
    private String email;
    private String mibao;
    private String mibaoVal;
    private int permission;
    private String salt;
}
