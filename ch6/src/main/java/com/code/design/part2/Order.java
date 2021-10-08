package com.code.design.part2;

import lombok.Getter;

@Getter
public class Order {

    private OrderMessage message;

    public Order(OrderMessage orderMessage) {
        this.message = orderMessage;
    }
}
