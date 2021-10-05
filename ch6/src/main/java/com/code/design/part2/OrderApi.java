package com.code.design.part2;

import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderApi {


    @PostMapping
    public Order create(@RequestBody @Valid OrderRequest request) {
        final Order order = new Order(OrderMessage.of(request.getMessageType()));

        return order;
    }

    @Getter
    public static class OrderRequest {

        @NotNull
        private Set<MessageType> messageType;
    }
}


