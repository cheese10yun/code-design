package com.code.design.test_1;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Junit5_3 {

    @Test
    @Order(1)
    void test_1() {
        System.out.println("test_1");
    }

    @Test
    @Order(2)
    void test_2() {
        System.out.println("test_2");
    }
}