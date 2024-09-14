package com.example.saso.service.impl;

import com.example.saso.domain.LoginUser;
import com.example.saso.entity.User;
import com.example.saso.mapper.UserMapper;
import com.example.saso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserdetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByName(username);
        if(user == null){
            throw new RuntimeException("用户名或密码错误");
        }
        //封装成UserDetails对象
        return new LoginUser(user);
    }
}
