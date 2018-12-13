package com.binfool.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 入口
 * @author bin
 * @date 2018/12/12 14:42
 */
@SpringBootApplication(exclude = { // we use the multiple datasources
		DataSourceAutoConfiguration.class
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
