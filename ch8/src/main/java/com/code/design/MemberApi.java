package com.code.design;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberApi {
    private final MemberRepository memberRepository;

    @PostMapping
    public void create(@RequestBody SignUpRequest dto) {
        memberRepository.save(dto.toEntity());
    }
}
