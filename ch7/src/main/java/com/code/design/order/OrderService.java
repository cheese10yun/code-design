package com.code.design.order;

import com.code.design.EmailSenderService;
import com.code.design.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final EmailSenderService emailSenderService;

    @Transactional
    public void doOrder(OrderRequest dto) {
        System.out.println("CurrentTransactionName: " + TransactionSynchronizationManager.getCurrentTransactionName());
        final Order order = orderRepository.save(dto.toEntity()); // 1. order 엔티티 영속화
        cartService.deleteCart(order); // 2. 주문상품 장바구니 제거
    }
}