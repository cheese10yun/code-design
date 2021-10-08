package com.code.design.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Orderer {

    @Column(name = "member_id", nullable = false, updatable = false)
    private Long memberId;

    @Column(name = "email", nullable = false, updatable = false)
    private String email;

}