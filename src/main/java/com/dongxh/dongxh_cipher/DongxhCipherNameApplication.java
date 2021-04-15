package com.dongxh.dongxh_cipher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication包含三个注解 @SpringBootConfiguration @EnableAutoConfiguration @ComponentScan
@MapperScan("com.dongxh.dongxh_cipher.mapper")
public class DongxhCipherNameApplication {

	public static void main(String[] args) {
		SpringApplication.run(DongxhCipherNameApplication.class, args);
	}

}
