package com.code.design.order;

import com.code.design.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;
//    private final CartService cartService;

    @Transactional
    public void doOrder(OrderRequest dto) {
        System.out.println("CurrentTransactionName: "
            + TransactionSynchronizationManager.getCurrentTransactionName()); // 현재 트랜잭션 정보 출력
        final Order order = orderRepository.save(dto.toEntity()); // 1. order 엔티티 영속화
//        cartService.deleteCart(order); // 2. 주문상품 장바구니 제거, 2초 대기, 예외 발생 -> cart, order rollback 진행..

        eventPublisher.publishEvent(new OrderCompletedEvent(order));
    }
}