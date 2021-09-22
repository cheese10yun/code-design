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
    @Builder
    public Account(final String bankName, final String accountNumber, final String accountHolder) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    // 안전한 객채 생성 패턴
//    @Builder
//    public Account(String bankName, String accountNumber, String accountHolder) {
//        Assert.hasText(bankName, "bankName must not be empty");
//        Assert.hasText(accountNumber, "accountNumber must not be empty");
//        Assert.hasText(accountHolder, "accountHolder must not be empty");
//
//        this.bankName = bankName;
//        this.accountNumber = accountNumber;
//        this.accountHolder = accountHolder;
//    }
}
