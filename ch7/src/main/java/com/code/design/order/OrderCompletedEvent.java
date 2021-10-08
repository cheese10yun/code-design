package com.code.design.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderCompletedEvent {

    private final Order order;

}
