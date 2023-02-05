package com.nahorniak.awstranslateapplication.api;

import com.nahorniak.awstranslateapplication.entity.Message;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("api/v1/")
public interface TranslatorApi {

    @Operation(summary = "translate message")
    @ApiResponse(
            responseCode = "200",
            description = "message successfully translated",
            content = { @Content(mediaType = "text/plain")})
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("translate")
    String translate(@RequestBody @NonNull Message message);
}
