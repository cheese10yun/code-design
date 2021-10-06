package com.code.design.lombok;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class StudentTest {

    @Test
    public void 클래스_상단의_Builder의_단점() {
        Student.builder()
            .build();
    }
}