package com.example.saso.service;


import com.example.saso.api.CommonResult;
import com.example.saso.entity.User;


public interface UserService{

    public String register(User user);

    String updateByUsername(User user);

    String deleteByUsername(User user);

}
