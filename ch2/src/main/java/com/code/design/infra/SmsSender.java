package com.code.design.infra;

public interface SmsSender {

    boolean send(final SmsMessageRequest smsMessageRequest);
}