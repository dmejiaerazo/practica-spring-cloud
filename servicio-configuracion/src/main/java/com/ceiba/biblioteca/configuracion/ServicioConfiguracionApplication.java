package com.ceiba.biblioteca.configuracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServicioConfiguracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioConfiguracionApplication.class, args);
	}

}
