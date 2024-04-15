package com.oms.service;

import com.oms.entity.SalesOrder;
import com.oms.util.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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

        Assertions.assertNotNull(order);
        Assertions.assertEquals("1234", order.getCustomerOrderId());
        Assertions.assertEquals("COMPLETED", order.getOrderStatus());
    }

    @Test
    public void testCreateOrder() {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setCustomerOrderId("1234");
        salesOrder.setOrderStatus("COMPLETED");

        Mockito.when(orderRepository.save(salesOrder)).thenReturn(salesOrder);

        SalesOrder order = orderService.saveOrder(salesOrder);

        Assertions.assertNotNull(order);
        Assertions.assertEquals("1234", order.getCustomerOrderId());
        Assertions.assertEquals("COMPLETED", order.getOrderStatus());
    }
}