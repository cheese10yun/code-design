package com.code.design.member;

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
    //    private final EmailSenderService emailSenderService;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void signUp(final MemberSignUpRequest dto) {
        final Member member = memberRepository.save(dto.toEntity()); // 1. member 엔티티 영속화
//        emailSenderService.sendSignUpEmail(member); // 2. 외부 시스템 이메일 호출
        eventPublisher.publishEvent(new MemberSignedUpEvent(member));
        couponIssueService.issueSignUpCoupon(member.getId()); // 3. 회원가입 쿠폰 발급 -> 예외 발생, 회원, 쿠폰 모두 롤백, 문제는 회원 가입 이메일 전송 완료...

    }
}
