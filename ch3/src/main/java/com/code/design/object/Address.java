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
public class Address {

    @Column(name = "address1", nullable = false)
    private String address1;

    @Column(name = "address2", nullable = false)
    private String address2;

    @Column(name = "zip", nullable = false)
    private String zip;

    @Builder
    public Address(final String address1, final String address2, final String zip) {
        Assert.hasText(address1, "address1 must not be empty");
        Assert.hasText(address2, "address2 must not be empty");
        Assert.hasText(zip, "zip must not be empty");

        this.address1 = address1;
        this.address2 = address2;
        this.zip = zip;
    }
}
