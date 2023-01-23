package com.nahorniak.awstranslateapplication.service.impl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClientBuilder;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import com.nahorniak.awstranslateapplication.config.AWSConfig;
import com.nahorniak.awstranslateapplication.entity.Message;
import com.nahorniak.awstranslateapplication.service.TranslateService;
import com.amazonaws.auth.BasicAWSCredentials;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AWSTranslateServiceImpl implements TranslateService {

    private final AWSConfig awsConfig;
    private AmazonTranslate client;

    @PostConstruct
    public void init() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(awsConfig.getApiKey(), awsConfig.getSecretKey());

        client = AmazonTranslateClientBuilder
                .standard()
                .withRegion(Regions.EU_CENTRAL_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    @Override
    public String translate(Message message) {
        TranslateTextRequest request = new TranslateTextRequest()
                .withText(message.getText())
                .withSourceLanguageCode(message.getSourceLang())
                .withTargetLanguageCode(message.getTargetLang());

        TranslateTextResult result = client.translateText(request);
        log.info("Text: {}, Source Lang: {}, Target Lang: {}, Result: {}",
                message.getText(),
                message.getSourceLang(),
                message.getTargetLang(),
                result.getTranslatedText());

        return result.getTranslatedText();
    }
}
