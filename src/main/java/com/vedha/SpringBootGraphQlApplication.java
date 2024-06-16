package com.vedha;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(description = "Spring Boot GraphQL", title = "Spring Boot GraphQL", version = "1.0"))
public class SpringBootGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphQlApplication.class, args);
	}

}
