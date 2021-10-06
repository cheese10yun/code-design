package com.code.design;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Exception1 {

    private final MemberRepository memberRepository;

    // 예외가 발생핬지만, 아무 처리도 하지 않고 로직을 진행한다.
    public void doXXX1(final Long id) {
        String name = null;
        try {
            final Member member = memberRepository.findById(id).get();
            name = member.getName();
        } catch (Exception e) {
            // 추가적인 작업을 진행하기 위해...
            log.error(e.getMessage());
        }
        System.out.println(name);
    }

    // 예외가 발생하면 예외 로그라도 찍는다.
    public void doXXX2(final Long id) {
        String name = null;
        try {
            final Member member = memberRepository.findById(id).get();
            name = member.getName();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        System.out.println(name);
    }

    // 예외가 발생하면 로그를 찍고, 더 구체적인 예외를 발생 시킨다.
    // 예외가 발생하면 로직을 이어갈 수 없는 경우는 Exception을 발생시켜 코드의 흐름을 끊는다.
    public void doXXX3(final Long id) {
        String name = null;
        try {
            final Member member = memberRepository.findById(id).get();
            name = member.getName();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("해당 id: " + id + " 의 member의 name은 null 입니다."); // 더 구체적인 예외를 직접 정의해서 사용해도 무방
        }
        System.out.println(name);
    }

    // 예외 처리가 가능하다면, Exception을 발생시키지 않고 로직적으로 풀어낸다
    public void doXXX4(final Long id) {
        String name = null;

        final Member member = memberRepository.findById(id).get();
        // exchange api  신한, 하나 -> 다른 대안을 찾을 수 있는지 검토

        if (member != null) {
            name = member.getName();
        } else {
            name = "Default Name";
        }
        System.out.println(name);
    }

    // 1. try catch를 최대한 지양해라.(로직으로 예외 처리가 가능하다면)
    // 2. try catch를 하는데 아무런 처리가 없다면 로그라도 추가하자
    // 3. try catch를 사용하게 된다면, 더 구체적인 예외를 발생시키는것이 좋다. (Exception 직접 정의 or Error Message를 명확하게)
}
