package com.example.saso.service.impl;

import com.example.saso.api.CommonResult;
import com.example.saso.domain.LoginUser;
import com.example.saso.entity.User;
import com.example.saso.service.LoginService;
import com.example.saso.util.JwtUtils;
import com.example.saso.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;
    /**
     * @param user
     * @return
     */
    @Override
    public CommonResult login(User user) {
        //创建UsernamePasswordAuthenticationToken对象，将用户名和密码作为参数传入
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        //调用AuthenticationManager的authenticate方法进行身份验证
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        //如果authentication对象为空，表示用户名或密码错误，抛出一个运行时异常
        if(authentication==null){
            throw new RuntimeException("用户名或密码错误");
        }
        //从authentication对象获取登录用户信息
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //获取用户id
        String userId = loginUser.getUser().getId().toString();
        //使用用户id生成一个JWT
        String jwt = JwtUtils.createJWT(userId);
        //将登陆用户信息存入redis缓存，以便后续验证用户的身份
        redisCache.setCacheObject("login:"+userId,loginUser);
        //创建包含Jwt的响应结果，并返回给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return CommonResult.success(map, "登录成功");
    }

    /**获取SecurityContextHolder认证信息,删除Redis对应数据
     * @return
     */
    @Override
    public CommonResult logout() {
        //获取SecurityContextHolder中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //获取用户id
        String userId = loginUser.getUser().getId().toString();
        //从redis中删除用户信息
        redisCache.deleteObject("login:"+userId);

        return new CommonResult(200,"登出成功");
    }














}
