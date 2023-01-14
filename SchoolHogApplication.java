package ru.hogwarts.schoolhog;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition
@SpringBootApplication
public class SchoolHogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolHogApplication.class, args);
    }

}
