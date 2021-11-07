package com.dadaepo.emo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.dadaepo.emo"})
@SpringBootApplication
public class EmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmoApplication.class, args);
	}

}
