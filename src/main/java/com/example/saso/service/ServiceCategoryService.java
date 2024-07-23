package com.example.saso.service;

import com.example.saso.entity.ServiceCategory;

import java.util.List;

public interface ServiceCategoryService {
    List<ServiceCategory> list();

    List<ServiceCategory> listWithTree();

    List<Integer> test();
}
