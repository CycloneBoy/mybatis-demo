package com.cycloneboy.mybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * Created by CycloneBoy on 2017/7/22.
 */
@Configuration
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.cycloneboy.mybatis.dao");
        Properties properties = new Properties();
        properties.setProperty("mappers","com.cycloneboy.mybatis.common.BaseDao");
        properties.setProperty("noEmpty","false");
        properties.setProperty("IDENTITY","MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return  mapperScannerConfigurer;
    }
}
