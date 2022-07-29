package com.ceiba.biblioteca.libro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioLibroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioLibroApplication.class, args);
	}

}
