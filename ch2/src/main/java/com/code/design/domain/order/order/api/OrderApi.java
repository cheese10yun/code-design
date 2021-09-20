package com.code.design.domain.order.order.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/orders")
public class OrderApi {


    @PostMapping()
    public void doOrder() {

    }

}
