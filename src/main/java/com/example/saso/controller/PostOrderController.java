package com.example.saso.controller;

import com.example.saso.api.CommonResult;
import com.example.saso.entity.Order;
import com.example.saso.service.PostOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
* 角色：企业/发单人
* 功能：发布、修改、删除订单等
* 优化：暂无
*/
@RestController
@RequestMapping("/order")
public class PostOrderController{
    @Autowired
    private PostOrderService postOrderService;

    @PostMapping("/post")
    @ResponseBody
    public CommonResult postOrder(@RequestBody Order order){
        //发布订单
        int res = postOrderService.postOrder(order);
        if(res > 0) {
            return CommonResult.success(res);
        }
        return CommonResult.failed("请填完所有必须项！");
    }

    /*指定要修改订单的id，进行对应记录的修改*/
    @PostMapping("/modify/{id}")
    @ResponseBody
    public CommonResult modifyOrder(@PathVariable("id") int id,@RequestBody Order order){
        //修改订单
        int count = postOrderService.modifyOrder(id,order);
        if(count > 0){
            return CommonResult.success(count);
        }
        return  CommonResult.failed();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public CommonResult deleteOrder(@PathVariable int id,@RequestBody Order order){
        //删除订单
        int count = postOrderService.deleteOrder(id,order);
        if(count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
