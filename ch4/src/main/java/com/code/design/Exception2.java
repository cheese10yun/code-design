package com.code.design;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

//  Check Exception VS UnChecked Exception
@Service
public class Exception2 {

    public void signUp(final String name) {
        final Member member = new Member(name);
//        printJson1(member); // printJson1 사용시 예외처리에 대한 위임을 받아 처리 해야한다.
//        printJson2(member); // printJson2 사용시 예외처리를 위임 받지 않아도 된다.

    }


    // throws를 통해서 호출한 메서드로 예외처리를 위임한다
    private void printJson1(final Member member) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String valueAsString = objectMapper.writeValueAsString(member);
        System.out.println(valueAsString);
    }

    // 예외 발생시 본인의 로직에서 예외를 발생시켜 예외처리를 호출한 쪽으로 위임하지 않는다.
    private void printJson2(final Member member) {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String valueAsString;
        try {
            valueAsString = objectMapper.writeValueAsString(member);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        System.out.println(valueAsString);
    }
}
