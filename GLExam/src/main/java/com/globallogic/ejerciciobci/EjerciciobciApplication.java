package com.globallogic.ejerciciobci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class EjerciciobciApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciobciApplication.class, args);
	}

}
