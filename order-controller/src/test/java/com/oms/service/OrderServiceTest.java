package com.oms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oms.entity.SalesOrder;
import com.oms.repository.SalesOrderRepository;
import com.oms.util.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    SalesOrderRepository orderRepository;

    OrderService orderService = new OrderService();

    @BeforeEach
    public void setUp() {
        orderService.orderRepository = orderRepository;
        orderService.setLogger(new Logger());
    }

    @Test
    public void testGetOrder() {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setCustomerOrderId("1234");
        salesOrder.setOrderStatus("COMPLETED");

        Mockito.when(orderRepository.findById("1234")).thenReturn(java.util.Optional.of(salesOrder));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(salesOrder));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        SalesOrder order = orderService.fetchOrder("1234");

        assertNotNull(order);
        assertEquals("1234", order.getCustomerOrderId());
        assertEquals("COMPLETED", order.getOrderStatus());
    }

    @Test
    public void testCreateOrder() {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setCustomerOrderId("1234");
        salesOrder.setOrderStatus("COMPLETED");

        Mockito.when(orderRepository.save(salesOrder)).thenReturn(salesOrder);

        SalesOrder order = orderService.saveOrder(salesOrder);

        assertNotNull(order);
        assertEquals("1234", order.getCustomerOrderId());
        assertEquals("COMPLETED", order.getOrderStatus());
    }
}