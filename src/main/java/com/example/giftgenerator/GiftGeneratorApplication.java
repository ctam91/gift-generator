package com.example.giftgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class GiftGeneratorApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(GiftGeneratorApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GiftGeneratorApplication.class, args);
	}
}
