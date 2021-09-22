package com.code.design.object;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    public void Account_accountHolder_비어있으면_exception() {
        thenThrownBy(() -> Account.builder()
            .accountHolder("")
            .accountNumber("110-22345-22345")
            .bankName("신한은행")
            .build()
        )
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Account_accountNumber_비어있으면_exception() {
        thenThrownBy(() -> Account.builder()
            .accountHolder("홍길동")
            .accountNumber("")
            .bankName("신한은행")
            .build()
        )
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Account_bankName_비어있으면_exception() {
        thenThrownBy(() -> Account.builder()
            .accountHolder("홍길동")
            .accountNumber("110-22345-22345")
            .bankName("")
            .build()
        )
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Account_모든_필수값을_입력() {
        final Account account = Account.builder()
            .accountHolder("홍길동")
            .accountNumber("110-22345-22345")
            .bankName("신한은행")
            .build();

        then(account.getAccountHolder()).isEqualTo("홍길동");
        then(account.getAccountNumber()).isEqualTo("110-22345-22345");
        then(account.getBankName()).isEqualTo("신한은행");
    }
}