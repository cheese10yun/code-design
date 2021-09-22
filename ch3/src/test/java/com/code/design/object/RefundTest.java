package com.code.design.object;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefundTest {

    private Order order;
    private Account account;
    private CreditCard creditCard;

    @BeforeEach
    public void setUp() throws Exception {

        final Address address = Address.builder()
            .address1("서울시 관악구 293-1")
            .address2("201호")
            .zip("503-23")
            .build();

        final List<Product> products = new ArrayList<>();


        ProductBuilder

        Order order = Order.builder()
            .address(address)
            .products(products)
            .build();

        account = Account.builder()
            .accountHolder("홍길동")
            .accountNumber("110-2304-22344")
            .bankName("신한은행")
            .build();

        creditCard = CreditCard.builder()
            .creditNumber("110-22345-22345")
            .creditHolder("홍길동")
            .build();
    }

    @Test
    public void ByAccountBuilder_test_account_null이면_excpetion() {

        thenThrownBy(() -> Refund.ByAccountBuilder()
            .account(null)
            .order(order)
            .build()
        )
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ByAccountBuilder_testorder_null이면_excpetion() {
        thenThrownBy(() -> Refund.ByAccountBuilder()
            .account(account)
            .order(null)
            .build()
        )
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ByAccountBuilder_test() {
        final Refund refund = Refund.ByAccountBuilder()
            .account(account)
            .order(order)
            .build();

        then(refund.getAccount()).isEqualTo(account);
        then(refund.getOrder()).isEqualTo(order);
    }


    @Test
    public void ByCreditBuilder_test_account_null이면_excpetion() {

        thenThrownBy(() -> Refund.ByCreditBuilder()
            .creditCard(null)
            .order(order)
            .build()
        )
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ByCreditBuilder_testorder_null이면_excpetion() {
        thenThrownBy(() -> Refund.ByCreditBuilder()
            .creditCard(creditCard)
            .order(null)
            .build()
        )
            .isInstanceOf(IllegalArgumentException.class);
    }

}