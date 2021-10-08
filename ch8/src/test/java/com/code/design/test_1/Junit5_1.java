package com.code.design.test_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Junit5_1 {

    private  int count = 0;
//    private static int count = 0;


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
