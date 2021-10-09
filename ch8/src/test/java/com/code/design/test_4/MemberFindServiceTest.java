package com.code.design.test_4;

import static org.assertj.core.api.BDDAssertions.then;

import com.code.design.Member;
import com.code.design.MemberFindService;
import com.code.design.MemberRepository;
import org.junit.jupiter.api.Test;

public class MemberFindServiceTest extends IntegrationTestSupport {

    private final MemberRepository memberRepository;
    private final MemberFindService memberFindService;

    public MemberFindServiceTest(MemberRepository memberRepository, MemberFindService memberFindService) {
        this.memberRepository = memberRepository;
        this.memberFindService = memberFindService;
    }

    @Test
    public void findByName_정상조회_케이스() {
        //given
        memberRepository.save(new Member("yun"));

        //when
        final Member member = memberFindService.findByName("yun");

        //then
        then(member.getName()).isEqualTo("yun");
    }
}
