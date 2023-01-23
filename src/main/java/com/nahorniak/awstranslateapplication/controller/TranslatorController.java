package com.nahorniak.awstranslateapplication.controller;

import com.nahorniak.awstranslateapplication.entity.Message;
import com.nahorniak.awstranslateapplication.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class TranslatorController {

    private final TranslateService service;

    @PostMapping("translate")
    public String translate(@RequestBody @NonNull Message message){
        return service.translate(message);
    }
}
