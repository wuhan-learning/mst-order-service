package com.thoughtworks.mstorderservice.api;

import com.thoughtworks.mstorderservice.dto.OrderDTO;
import com.thoughtworks.mstorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }

    @PatchMapping(value = "/{id}")
    public OrderDTO pay(
        @PathVariable("id") long orderId,
        @RequestParam(value = "action") String action) {
        if ("pay".equals(action)) {
            orderService.pay(orderId);
        }
        return orderService.getOrder(orderId);
    }

}
