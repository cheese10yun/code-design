package com.code.design.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderApi {

    private final OrderService orderService;

    @PostMapping
    public void doOrder(OrderRequest dto) {
        orderService.doOrder(dto);
    }

}
