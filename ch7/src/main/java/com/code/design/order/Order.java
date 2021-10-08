package com.code.design.order;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_amount", nullable = false)
    private BigDecimal productAmount;

    @Embedded
    private Orderer orderer;

    public Order(Long productId, BigDecimal productAmount, Orderer orderer) {
        this.productId = productId;
        this.productAmount = productAmount;
        this.orderer = orderer;
    }
}

