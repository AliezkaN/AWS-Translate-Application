package com.nahorniak.awstranslateapplication.service;

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

    @Autowired
    private AWSTranslateServiceImpl awsTranslateService;

    @Test
    void translate_fromEnglish_toUkrainian(){

        String targetLanguage = "uk";
        String expectedResponse = "Привіт друже!";

        String actualResponse = awsTranslateService.translate(INPUT,SOURCE_LANG,targetLanguage);

        assertNotNull(actualResponse);
        assertEquals(actualResponse,expectedResponse);

    }

    @Test
    void translate_fromEnglish_toGerman(){

        String targetLanguage = "de";
        String expectedResponse = "Hallo Freund!";

        String actualResponse = awsTranslateService.translate(INPUT,SOURCE_LANG,targetLanguage);

        assertNotNull(actualResponse);
        assertEquals(actualResponse,expectedResponse);

    }

    @Test
    void translate_fromEnglish_toPolish(){

        String targetLanguage = "pl";
        String expectedResponse = "Witaj przyjacielu!";

        String actualResponse = awsTranslateService.translate(INPUT,SOURCE_LANG,targetLanguage);

        assertNotNull(actualResponse);
        assertEquals(actualResponse,expectedResponse);

    }

    @Test
    void translate_fromEnglish_toJapanese(){

        String targetLanguage = "ja";
        String expectedResponse = "こんにちは、友達！";

        String actualResponse = awsTranslateService.translate(INPUT,SOURCE_LANG,targetLanguage);

        assertNotNull(actualResponse);
        assertEquals(actualResponse,expectedResponse);

    }



}
