package com.code.design.test_1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Junit5_2 {

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll : 테스트 실행되기 이전 단 한 번만 실행");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll : 테스트 실행되기 이전 단 한 번만 실행");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach: 모든 테스트 마다 실행되기 이전 실행 ");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach : 모든 테스트 마다 실행 이후 실행");
    }

    @Test
    void test_1() {
        System.out.println("test_1");
    }

    @Test
    void test_2() {
        System.out.println("test_2");
    }
}