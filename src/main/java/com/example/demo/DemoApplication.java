package com.example.demo;

import com.example.demo.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println(Config.getParam("dev","a"));
		SpringApplication.run(DemoApplication.class, args);
	}
}
