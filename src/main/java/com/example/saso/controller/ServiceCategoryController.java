package com.example.saso.controller;

import com.example.saso.api.CommonResult;
import com.example.saso.entity.ServiceCategory;
import com.example.saso.service.ServiceCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//优化点：需要再adminController补充对服务分类的add\delete\、update等操作
@ApiOperation(value = "服务分类")
@RestController
@RequestMapping("/service")
public class ServiceCategoryController {
    @Autowired
    private ServiceCategoryService serviceCategoryService;

    @ApiOperation(value = "获取服务分类")
    @GetMapping("/category")
    public CommonResult getServiceCategory() {
        List<ServiceCategory> serviceCategoryList = serviceCategoryService.listWithTree();
        return CommonResult.success(serviceCategoryList);
    }

/*    @GetMapping("/test")
    public List<Integer> Test(){
        return serviceCategoryService.test();
    }*/















}
