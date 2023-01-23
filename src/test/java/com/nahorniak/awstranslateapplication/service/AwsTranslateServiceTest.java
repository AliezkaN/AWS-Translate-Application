package com.nahorniak.awstranslateapplication.service;

import com.nahorniak.awstranslateapplication.entity.Message;
import com.nahorniak.awstranslateapplication.service.impl.AWSTranslateServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource("classpath:application.yml")
public class AwsTranslateServiceTest {

    private static final String INPUT = "Hello friend!";
    private static final String SOURCE_LANG = "en";
    private static final String TARGET_LANG = "uk";
    private static final String TRANSLATED_TEXT = "Привіт друже!";

    @Autowired
    private AWSTranslateServiceImpl awsTranslateService;

    @Test
    void translate(){

        Message message = Message
                .builder()
                .text(INPUT)
                .sourceLang(SOURCE_LANG)
                .targetLang(TARGET_LANG)
                .build();

        String actualResponse = awsTranslateService.translate(message);

        assertNotNull(actualResponse);
        assertEquals(actualResponse,TRANSLATED_TEXT);

    }

}
