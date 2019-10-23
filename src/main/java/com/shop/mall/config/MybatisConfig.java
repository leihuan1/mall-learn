package com.shop.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.shop.mall.mapper")
public class MybatisConfig {
}
