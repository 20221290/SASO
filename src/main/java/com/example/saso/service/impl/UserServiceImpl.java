package com.example.saso.service.impl;


import com.example.saso.entity.User;
import com.example.saso.entity.UserExample;
import com.example.saso.mapper.UserMapper;
import com.example.saso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  // 密码加密器

    @Override
    public String register(User user) {
        UserExample userExample =  new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> list= userMapper.selectByExample(userExample);
        //select * from user where username = user.getUsername();

//        User userEquals = userMapper.findByUsername(user.getUsername());
        if(list.isEmpty()){
            if(user.getUsername().isEmpty()){
                return "用户名不为空";
            } else if (user.getPassword().isEmpty()) {
                return "密码不为空";
            }else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userMapper.insert(user);
                return "success";
            }
        }
        return "注册失败，用户已存在";
    }

    /**
     * @param
     * @return
     */
    @Override
    public String updateByUsername(User user) {
        UserExample userExample =  new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> list= userMapper.selectByExample(userExample);
        if(!list.isEmpty()){
            userMapper.updateByUsername(user);
            return "success";
        }
        return "修改用户信息失败";
    }

    @Override
    public String deleteByUsername(User user) {
        UserExample userExample =  new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> list= userMapper.selectByExample(userExample);
        if(!list.isEmpty()){
            userMapper.deleteByUsername(user);
//            System.out.println(userMapper.deleteByUsername(user));
            return "success";
        }
        return "销毁账号失败";
    }

    /**
     * @param
     * @return
     */

}
