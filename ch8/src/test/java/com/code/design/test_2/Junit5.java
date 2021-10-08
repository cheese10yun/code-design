package com.code.design.test_2;


import static org.assertj.core.api.BDDAssertions.then;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Junit5 {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void valueSource_1(String value) {
        System.out.println(value);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false, false})
    void valueSource_2(boolean value) {
        System.out.println(value);
    }

    @ParameterizedTest
    @EnumSource(Quarter.class)
    void enumSource_1(Quarter quarter) {
        then(quarter.getValue()).isIn(1, 2, 3, 4);
    }

    @ParameterizedTest
    @EnumSource(value = Quarter.class, names = {"Q1", "Q2"})
    void enumSource_2(Quarter quarter) {
        then(quarter.getValue()).isIn(1, 2);
        then(quarter.getValue()).isNotIn(3, 4);
    }

    @ParameterizedTest
    @CsvSource(
        value = {
            "010-1234-1234,01012341234",
            "010-2333-2333,01023332333",
            "02-223-1232,022231232"
        }
    )
    void csvSource(String value, String expected) {
        final String number = value.replace("-", "");
        then(number).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("providerOrder")
    void methodSource(Order order, int expectedTotalPrice) {
        then(order.getTotalPrice()).isEqualTo(expectedTotalPrice);
    }

    static List<Arguments> providerOrder() {
        final List<Arguments> arguments = new ArrayList<>();

        arguments.add(Arguments.of(new Order(100, 2), 200));
        arguments.add(Arguments.of(new Order(100, 3), 300));

        return arguments;
    }
}

enum Quarter {
    Q1(1, "1분기"),
    Q2(2, "2분기"),
    Q3(3, "3분기"),
    Q4(4, "4분기");

    private final int value;
    private final String description;

    Quarter(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}

class Order {

    private int price;
    private int quantity;

    public Order(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return price * quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}