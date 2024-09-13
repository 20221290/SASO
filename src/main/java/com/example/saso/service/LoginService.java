package com.example.saso.service;

import com.example.saso.api.CommonResult;
import com.example.saso.entity.User;

public interface LoginService {
    CommonResult login(User user);

    CommonResult logout();
}
