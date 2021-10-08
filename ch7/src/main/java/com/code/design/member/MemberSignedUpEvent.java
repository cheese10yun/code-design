package com.code.design.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberSignedUpEvent {

    private final Member member;
}
