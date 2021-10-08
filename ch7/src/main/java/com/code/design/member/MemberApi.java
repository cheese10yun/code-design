package com.code.design.member;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberSignUpService memberSignUpService;
    private final MemberRepository memberRepository;

    @GetMapping
    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    @PostMapping
    public void signUp(@RequestBody MemberSignUpRequest dto) {
        memberSignUpService.signUp(dto);
    }
}
