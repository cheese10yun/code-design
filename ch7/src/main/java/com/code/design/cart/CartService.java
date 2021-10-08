package com.code.design.cart;

import com.code.design.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    @Transactional
    public void deleteCart(Order order) {
        System.out.println("CurrentTransactionName: " + TransactionSynchronizationManager.getCurrentTransactionName());
        cartRepository.deleteByProductId(order.getProductId());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        throw new RuntimeException("runtime exception ...."); // 예외 발생
    }
}