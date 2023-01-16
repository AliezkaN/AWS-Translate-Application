package com.nahorniak.awstranslateapplication.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "aws")
public class AWSConfig {
    private String apiKey;
    private String secretKey;
}
