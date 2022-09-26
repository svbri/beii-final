package com.dh.configserviceparcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServiceParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServiceParcialApplication.class, args);
	}

}
