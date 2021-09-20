package com.code.design.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class KtSmsSenderClient {

    public SendResponse send(final SendRequest dto) {
        final ResponseEntity<SendResponse> response = new RestTemplate().postForEntity(
            "https://xxxx.xxxx.xxx", dto, SendResponse.class);

        return response.getBody();
    }

    @Getter
    @AllArgsConstructor
    public static class SendRequest {

        final String message;
        final String receiver;

    }

    @Getter
    @AllArgsConstructor
    public static class SendResponse {

        final boolean success;
    }
}