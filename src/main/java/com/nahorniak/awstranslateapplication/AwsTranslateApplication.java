package com.nahorniak.awstranslateapplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "Translate API",
        version = "1.0",
        description = "Translate your messages with Translate API"))
public class AwsTranslateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsTranslateApplication.class, args);
    }

}
