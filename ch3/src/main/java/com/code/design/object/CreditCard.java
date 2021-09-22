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
public class CreditCard {

    @Column(name = "credit_number", nullable = false)
    private String creditNumber;

    @Column(name = "credit__holder", nullable = false)
    private String creditHolder;

    @Builder
    public CreditCard(final String creditNumber, final String creditHolder) {
        Assert.hasText(creditNumber, "creditNumber must not be empty");
        Assert.hasText(creditHolder, "creditHolder must not be empty");

        this.creditNumber = creditNumber;
        this.creditHolder = creditHolder;
    }
}