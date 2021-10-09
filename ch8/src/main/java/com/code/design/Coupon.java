package com.code.design;


import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    private long id;

    private boolean used;

    private double amount;

    private LocalDate expirationDate;

    public Coupon(double amount, LocalDate expirationDate) {
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.used = false;
    }

    public boolean isExpiration() {
        return LocalDate.now().isAfter(expirationDate);
    }

    public void apply() {
        verifyCouponIsAvailable();
        this.used = true;
    }

    private void verifyCouponIsAvailable() {
        verifyExpiration();
        verifyUsed();
    }

    private void verifyUsed() {
        if (used) {
            throw new IllegalStateException("이미 사용한 쿠폰입니다.");
        }
    }

    private void verifyExpiration() {
        if (LocalDate.now().isAfter(getExpirationDate())) {
            throw new IllegalStateException("사용 기간이 만료된 쿠폰입니다.");
        }
    }
}
