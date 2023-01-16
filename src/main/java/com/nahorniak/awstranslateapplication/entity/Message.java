package com.nahorniak.awstranslateapplication.entity;

import lombok.Data;

@Data
public class Message {
    private String text;
    private String sourceLang;
    private String targetLang;
}
