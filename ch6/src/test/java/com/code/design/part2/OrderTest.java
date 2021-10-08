package com.code.design.part2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    public void 객체_디자인() {
        final Set<MessageType> types = new HashSet<>();
        types.add(MessageType.EMAIL);
        types.add(MessageType.KAKAO);
        types.add(MessageType.SMS);

        // 1. Order 객체 생성시 주문에 대한 메시지 플랫폼의 책임을 온전히 OrderMessage에게 이관 했다
        final OrderMessage message = OrderMessage.of(types);
        final Order order = new Order(message);

        // 2. 실제 데이터베이스에서는 "SMS,KAKAO,EMAL" 이런 평문자열로 저장되어 있지만
        // 사용하는 곳에서는 데이터베이스에 평문자열로 저장되었는지 신경쓰지
        // 않고 List객체로 안전하게 사용 할수 있다.
        final OrderMessage orderMessage = order.getMessage();
        final List<MessageType> messageTypes = orderMessage.getTypes();

        for (MessageType messageType : messageTypes) {
            System.out.println(messageType.name());
        }
    }
}