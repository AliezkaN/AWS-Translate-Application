package com.nahorniak.awstranslateapplication.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/")
public interface TranslatorApi {

    @Operation(summary = "translate message")
    @ApiResponse(
            responseCode = "200",
            description = "message successfully translated",
            content = { @Content(mediaType = "text/plain")})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("translate")
    String translate(@RequestParam String text,
                     @RequestParam(name = "sourceLang") String sourceLanguage,
                     @RequestParam(name = "targetLang") String targetLanguage);
}
