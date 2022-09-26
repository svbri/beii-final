package com.dh.eurekaserviceparcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceParcialApplication.class, args);
	}

}
