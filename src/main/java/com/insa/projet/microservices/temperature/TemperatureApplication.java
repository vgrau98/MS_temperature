package com.insa.projet.microservices.temperature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class TemperatureApplication extends SpringBootServletInitializer{

	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TemperatureApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TemperatureApplication.class, args);
	}

}
