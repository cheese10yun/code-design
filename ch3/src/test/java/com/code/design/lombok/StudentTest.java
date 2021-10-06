package com.code.design.lombok;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    // Student 자기 자신의 객체가, 본인의 생성되는 플로우에서 보다 명확하게 필요한 값과 필요하지 않은 값을 구분해서 받게 한다.
    public void 클래스_상단의_Builder의_단점() {
        final Student student = Student.builder()
            .email("asd@asd.com")
            .name("asd")
            .build();

        System.out.println(student);
    }
}