package com.sg;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
//@MapperScan("com.sg.mapper")
public class SpringBootRun {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootRun.class, args);
	}
}