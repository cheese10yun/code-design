package com.code.design.infra;

import lombok.Getter;

@Getter
public class SmsMessageRequest {

    private String message;
    private String senderNumber;
    private String receiverNumber;
    private String itc;
}
