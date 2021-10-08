package com.code.design.order;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class OrderRequest {

    private BigDecimal productAmount;
    private Long productId;
    private Orderer orderer;

    public Order toEntity() {
        return new Order(productId, productAmount, orderer);
    }
}
