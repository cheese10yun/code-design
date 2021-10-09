package com.code.design.test_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class Junit5_1 {

    private int count = 0;

    // 테스트 코드가 실행될떄 마다, 매번 새롭게 인스턴스가 만들어진다.
    // 테스트 코드간의 디펜던시를 줄이기 위함.

    @Test
    void count_add_1() {
        count = count + 1;
        System.out.println("count: " + count);
        System.out.println("Junit5_1: " + this);
    }

    @Test
    void count_add_2() {
        count = count + 1;
        System.out.println("count: " + count);
        System.out.println("Junit5_1: " + this);
    }
}
