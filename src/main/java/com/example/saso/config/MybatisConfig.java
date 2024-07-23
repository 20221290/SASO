package com.example.saso.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//自定义放dao，MBG生成放mapper
@MapperScan({"com.example.saso.mapper","com.example.saso.mapper"})
public class MybatisConfig {
}
