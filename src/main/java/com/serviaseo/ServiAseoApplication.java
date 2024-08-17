package com.serviaseo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.serviaseo.core.domain")
public class ServiAseoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiAseoApplication.class, args);
	}
}