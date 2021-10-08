package com.code.design.cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    void deleteByProductId(Long productId);
}
