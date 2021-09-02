package com.bff.tareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BffTareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BffTareasApplication.class, args);
	}

}
