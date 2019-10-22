package com.cdivtc;

import com.cdivtc.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
@MapperScan(basePackages = "com.cdivtc.mapper")
@SpringBootApplication
@ImportResource(locations = {"classpath:kaptcha.xml"})

public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	public IdWorker idWorker(){return new IdWorker();}
}
