package com.myblog.demo;

/*  */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //включает автоконфигурацию , сканирование компонентов и конфигурацию Spring Boot
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
