package com.code.design.object;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    public void Account_account_holder_비어있으면_exception() {
        thenThrownBy(() -> Account.builder()
            .accountHolder("")
            .bankName("KB")
            .accountNumber("11010101010")
            .build()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Account_account_holder_null_exception() {
        thenThrownBy(() -> Account.builder()
            .accountHolder(null)
            .bankName("KB")
            .accountNumber("11010101010")
            .build()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Account_bank_name_비어있으면_exception() {
        thenThrownBy(() -> Account.builder()
            .accountHolder("yun")
            .bankName("")
            .accountNumber("11010101010")
            .build()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Account_bank_name_null_exception() {
        thenThrownBy(() -> Account.builder()
            .accountHolder("yun")
            .bankName(null)
            .accountNumber("11010101010")
            .build()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Account_account_number_비어있으면_exception() {
        thenThrownBy(() -> Account.builder()
            .accountHolder("yun")
            .bankName("KB")
            .accountNumber("")
            .build()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Account_account_number_null_exception() {
        thenThrownBy(() -> Account.builder()
            .accountHolder("yun")
            .bankName("KB")
            .accountNumber(null)
            .build()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Account_모든_필수값을_입력_하면_성공() {
        final Account account = Account.builder()
            .accountHolder("yun")
            .bankName("KB")
            .accountNumber("11010101010")
            .build();

        then(account.getAccountHolder()).isEqualTo("yun");
        then(account.getBankName()).isEqualTo("KB");
        then(account.getAccountNumber()).isEqualTo("11010101010");
    }
}