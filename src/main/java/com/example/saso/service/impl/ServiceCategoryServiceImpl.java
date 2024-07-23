package com.example.saso.service.impl;

import com.example.saso.entity.ServiceCategory;
import com.example.saso.mapper.ServiceCategoryMapper;
import com.example.saso.service.ServiceCategoryService;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService {
    @Autowired
    ServiceCategoryMapper serviceCategoryMapper;

    @Override
    public List<ServiceCategory> list() {
        return serviceCategoryMapper.list();
    }
    @Override
    public List<Integer> test(){
        System.out.println(serviceCategoryMapper.test());
        return serviceCategoryMapper.test();
    }
    /**
     * @return
     */
    @Override
    public List<ServiceCategory> listWithTree() {
        List<ServiceCategory> entities = list();
        List<ServiceCategory> serviceCategoriesVOS = entities.stream().map(service -> {
            ServiceCategory serviceCategoryVO = new ServiceCategory();
            BeanUtils.copyProperties(service,serviceCategoryVO);
            return serviceCategoryVO;
        }).collect(Collectors.toList());
        List<ServiceCategory> list = serviceCategoriesVOS.stream().filter(serviceCategoryVO ->
                serviceCategoryVO.getParentId() == 0).map((menu) -> {
                    menu.setChildren(getChildrenData(menu, serviceCategoriesVOS));
                    return menu;
        }).collect(Collectors.toList());
        return list;
    }

    private List<ServiceCategory> getChildrenData(ServiceCategory root, List<ServiceCategory> all) {
        List<ServiceCategory> children = all.stream().filter(serviceCategoryVO -> serviceCategoryVO.getParentId().equals(root.getId()))
                .map(serviceCategoryVO -> {
            serviceCategoryVO.setChildren(getChildrenData(serviceCategoryVO,all));
            return serviceCategoryVO;
        }).collect(Collectors.toList());
        return children;
    }
}
