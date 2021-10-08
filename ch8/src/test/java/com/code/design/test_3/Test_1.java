package com.code.design.test_3;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.Java6Assertions.assertThat;

import com.code.design.Member;
import com.code.design.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("test")
@DataJpaTest
public class Test_1 {

    private final MemberRepository memberRepository;

    public Test_1(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Test
    public void member_save_test() {
        //given
        final String name = "name";

        //when
        final Member member = memberRepository.save(new Member(name));

        //then
        // 기존 사용법 assertThat
        assertThat(member.getName()).isEqualTo(name);

        // BDD 사용법
        then(member.getName()).isEqualTo(name);
    }
}