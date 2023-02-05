package com.nahorniak.awstranslateapplication.controller;

import com.nahorniak.awstranslateapplication.api.TranslatorApi;
import com.nahorniak.awstranslateapplication.entity.Message;
import com.nahorniak.awstranslateapplication.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TranslatorController implements TranslatorApi {

    private final TranslateService service;

    @Override
    public String translate(Message message) {
        return service.translate(message);
    }
}
