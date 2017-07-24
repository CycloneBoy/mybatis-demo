package com.cycloneboy.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.cycloneboy.mybatis")
@SpringBootApplication
public class MybatisSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisSpringbootApplication.class, args);
	}
}
