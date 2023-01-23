package com.nahorniak.awstranslateapplication.service;


import com.nahorniak.awstranslateapplication.entity.Message;

public interface TranslateService {
    String translate(Message message);
}
