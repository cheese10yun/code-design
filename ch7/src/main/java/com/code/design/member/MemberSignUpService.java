package com.code.design.member;

import com.code.design.EmailSenderService;
import com.code.design.coupon.CouponIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberSignUpService {

    private final MemberRepository memberRepository;
    private final CouponIssueService couponIssueService;
    private final EmailSenderService emailSenderService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void signUp(final MemberSignUpRequest dto) {
        final Member member = memberRepository.save(dto.toEntity()); // 1. member 엔티티 영속화
        emailSenderService.sendSignUpEmail(member); // 2. 외부 시스템 이메일 호출
        couponIssueService.issueSignUpCoupon(member.getId()); // 3. 회원가입 쿠폰 발급
    }
}
