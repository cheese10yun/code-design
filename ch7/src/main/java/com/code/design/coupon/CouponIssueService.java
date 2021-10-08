package com.code.design.coupon;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CouponIssueService {

    private final CouponRepository couponRepository;

    @Transactional
    public void issueSignUpCoupon(Long memberId) {
        couponRepository.save(new Coupon(BigDecimal.TEN, memberId));
//        throw new RuntimeException("RuntimeException....");
    }
}
