package com.planets.microservice_demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroserviceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDemoApplication.class, args);
	}
    @Bean
	 public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
