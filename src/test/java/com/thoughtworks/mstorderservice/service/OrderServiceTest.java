package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.repository.OrderRepository;
import com.thoughtworks.mstorderservice.dto.OrderDTO;
import com.thoughtworks.mstorderservice.entity.Order;
import com.thoughtworks.mstorderservice.helper.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    void should_create_order_successful() {
        Order newOrder = new Order();
        newOrder.setId(1);
        when(orderRepository.save(any(Order.class))).thenReturn(newOrder);

        OrderDTO orderDTO = new OrderDTO();
        OrderDTO savedOrder = orderService.create(orderDTO);
        verify(orderRepository, times(1)).save(any(Order.class));
    }
}