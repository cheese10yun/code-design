package com.code.design.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AmazonSmsClient {

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
        final String itu;

    }

    @Getter
    @AllArgsConstructor
    public static class SendResponse {

        final String status; // SUCCESS, FAILED_1(없는 전화번호), FAILED_2(수신거부), FAILED_3(실패 사유 알 수 없음)
    }

}
