package com.code.design;

import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    // rollback 진행 O
    @PostMapping("/unchekced")
    public Member unchekced() {
        final Member member = memberService.createUncheckedException();
        return member;
    }

    // rollback 진행 X
    @PostMapping("/chekced")
    public Member chekced() throws IOException {
        final Member member = memberService.createCheckedException();
        return member;
    }
}
