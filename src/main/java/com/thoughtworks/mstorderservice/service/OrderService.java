package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.repository.OrderRepository;
import com.thoughtworks.mstorderservice.dto.OrderDTO;
import com.thoughtworks.mstorderservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderDetail(orderDTO.getOrderDetail());
        Order savedOrder = orderRepository.save(order);
        return renderOrderDTO(savedOrder);
    }
    
    private OrderDTO renderOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderDetail(order.getOrderDetail());
        return orderDTO;
    }
}
