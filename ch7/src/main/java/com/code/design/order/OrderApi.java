package com.code.design.order;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderApi {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @PostMapping
    public void doOrder(@RequestBody OrderRequest dto) {
        orderService.doOrder(dto);
    }

    @GetMapping
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

}
