package com.example.saso.controller;

import com.example.saso.api.CommonResult;
import com.example.saso.entity.User;

import com.example.saso.mapper.UserMapper;
import com.example.saso.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/*可优化:加入security认证授权，使用token进行用户敏感操作（修改、注册、登录等）
* 用户登录、登出操作*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private  UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    @ResponseBody
    public CommonResult<User> register(@RequestBody User user) {
        String msg = userService.register(user);
        if (msg.equals("success")){
            return CommonResult.success(user);
        }
        else {
            return CommonResult.failed(msg);
        }
    }

    /*可优化方面:1.检查用户信息修改前后是否相同，相同则不予以修改
               2.采用token的方式而非用户名进行数据库查找*/
    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public CommonResult updateByUser(@RequestBody User user) {
        String msg = userService.updateByUsername(user);
        if (msg.equals("success")){
            return CommonResult.success(user);
        }
        else {
            return CommonResult.failed(msg);
        }
    }

    @ApiOperation("销毁用户账号")
    @PostMapping("/delete")
    public CommonResult deleteByUsername(@RequestBody User user) {
        String msg = userService.deleteByUsername(user);
        if (msg.equals("success")){
            return CommonResult.success(user);
        }
        else {
            return CommonResult.failed(msg);
        }
    }
}
