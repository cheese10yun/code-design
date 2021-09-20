package com.code.design.domain.order.order.domain;

import com.code.design.domain.model.Address;
import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Tracking {

    private Address address;
}
