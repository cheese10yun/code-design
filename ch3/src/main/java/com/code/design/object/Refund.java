package com.code.design.object;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table(name = "refund")
@Getter
@NoArgsConstructor
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Account account;

    @Embedded
    private CreditCard creditCard;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


    @Builder(builderClassName = "ByAccountBuilder", builderMethodName = "ByAccountBuilder") // 계좌 번호 기반 환불, Builder 이름을 부여해서 그에 따른 책임 부여, 그에 따른 필수 인자값 명확
    public Refund(Account account, Order order) {
        Assert.notNull(account, "account must not be null");
        Assert.notNull(order, "order must not be null");

        this.order = order;
        this.account = account;
    }

    @Builder(builderClassName = "ByCreditBuilder", builderMethodName = "ByCreditBuilder")  // 신용 카드 기반 환불, Builder 이름을 부여해서 그에 따른 책임 부여, 그에 따른 필수 인자값 명확
    public Refund(CreditCard creditCard, Order order) {
        Assert.notNull(creditCard, "creditCard must not be null");
        Assert.notNull(order, "order must not be null");

        this.order = order;
        this.creditCard = creditCard;
    }
}