package com.code.design.infra;

import com.code.design.infra.KtSmsSenderClient.SendRequest;
import com.code.design.infra.KtSmsSenderClient.SendResponse;

public class KtSmsSenderService implements SmsSender {

    @Override
    public boolean send(final SmsMessageRequest dto) {

        final KtSmsSenderClient client = new KtSmsSenderClient();
        final SendResponse response = client.send(new SendRequest(dto.getMessage(), dto.getReceiverNumber()));
        return response.success;
    }
}