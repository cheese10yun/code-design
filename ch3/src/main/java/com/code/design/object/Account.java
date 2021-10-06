package com.code.design.object;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "account_holder", nullable = false)
    private String accountHolder;

     // 불안전한 객채 생성 패턴
     // 그냥 단순하게 검증 아니라, 객체의 본인의 책임을 다하는 코드로 변경 했음
    @Builder
    public Account(final String bankName, final String accountNumber, final String accountHolder) {
        Assert.hasText(bankName, "bankName mut not be empty");
        Assert.hasText(accountNumber, "accountNumber mut not be empty"); // 특수문자 제거 or "-"  제거
        Assert.hasText(accountHolder, "accountHolder mut not be empty");

        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }
}
