package com.serviaseo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.serviaseo.repository")
@EntityScan(basePackages = "com.serviaseo.model")
public class ServiAseoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiAseoApplication.class, args);
	}
}