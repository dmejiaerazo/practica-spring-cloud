package com.ceiba.biblioteca.prestamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ServicioPrestamoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioPrestamoApplication.class, args);
	}

}
