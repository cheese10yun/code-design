package com.code.design.object;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CreditCardTest {

    @Test
    public void Account_creditNumber_비어있으면_exception() {
        thenThrownBy(() -> CreditCard.builder()
            .creditNumber("")
            .creditHolder("홍길동")
            .build()
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    public void Account_creditHolder_비어있으면_exception() {
        thenThrownBy(() -> CreditCard.builder()
            .creditNumber("10-22345-22345")
            .creditHolder("")
            .build()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Account_test() {
        final CreditCard address = CreditCard.builder()
            .creditNumber("110-22345-22345")
            .creditHolder("홍길동")
            .build();

        assertThat(address.getCreditHolder()).isEqualTo("홍길동");
        assertThat(address.getCreditNumber()).isEqualTo("110-22345-22345");
    }
}