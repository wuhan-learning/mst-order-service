package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.dto.OrderDTO;
import com.thoughtworks.mstorderservice.entity.Order;
import com.thoughtworks.mstorderservice.enums.OrderStatus;
import com.thoughtworks.mstorderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO create(OrderDTO orderDTO) {
        Order order = new Order();
        order.setNumber(orderDTO.getNumber());
        order.setStatus(OrderStatus.CREATED);
        Order savedOrder = orderRepository.save(order);
        return renderOrderDTO(savedOrder);
    }

    private OrderDTO renderOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        if (order != null) {
            orderDTO.setId(order.getId());
            orderDTO.setNumber(order.getNumber());
            orderDTO.setStatus(order.getStatus());
        }
        return orderDTO;
    }

    public void pay(long orderId) {
        Order order = orderRepository.getOne(orderId);
        if (order != null) {
            order.setStatus(OrderStatus.PAYED);
            orderRepository.save(order);
        }
    }

    public OrderDTO getOrder(long orderId) {
        Order order = orderRepository.getOne(orderId);
        return renderOrderDTO(order);
    }
}
