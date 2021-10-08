package com.code.design.part2;

public class OrderLegacy {

    private long id;
    // KAKAO, SMS, EMAIL 등 메세지 플랫폼등이 있음
    private String messageTypes;

    public OrderLegacy(String messageTypes) {
        this.messageTypes = messageTypes;
    }

    public String[] getMessageTypes() {
        return messageTypes.split(",");
    }
}
