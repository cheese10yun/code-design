package com.code.design.part2;



import static org.assertj.core.api.BDDAssertions.then;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class OrderMessageTest {

    @Test
    public void 메시지_타입이_EMAIL_KAKAO_SMS_일경우() {
        final Set<MessageType> types = new HashSet<>();
        types.add(MessageType.EMAIL);
        types.add(MessageType.KAKAO);
        types.add(MessageType.SMS);

        final OrderMessage message = OrderMessage.of(types);

        then(message.getTypes()).contains(MessageType.EMAIL, MessageType.KAKAO, MessageType.SMS);
        then(message.getTypes()).hasSize(3);
    }

    @Test
    public void 메시지_타입이_EMAIL_KAKAO일경우() {
        final Set<MessageType> types = new HashSet<>();
        types.add(MessageType.EMAIL);
        types.add(MessageType.KAKAO);

        final OrderMessage message = OrderMessage.of(types);

        then(message.getTypes()).contains(MessageType.EMAIL,MessageType.KAKAO);
        then(message.getTypes()).doesNotContain(MessageType.SMS);
        then(message.getTypes()).hasSize(2);
    }

    @Test
    public void 메시지_타입이_없을경우() {
        final Set<MessageType> types = Collections.emptySet();
        final OrderMessage message = OrderMessage.of(types);

        then(message.getTypes()).hasSize(0);
    }

    @Test
    public void 메시지_타입이_중복되는경우() {
        final Set<MessageType> types = new HashSet<>();
        types.add(MessageType.EMAIL);
        types.add(MessageType.EMAIL);
        types.add(MessageType.EMAIL);

        final OrderMessage message = OrderMessage.of(types);

        then(message.getTypes()).contains(MessageType.EMAIL);
        then(message.getTypes()).doesNotContain(MessageType.SMS, MessageType.KAKAO);
        then(message.getTypes()).hasSize(1);
    }

}