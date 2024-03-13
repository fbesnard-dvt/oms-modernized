package com.oms.controller;

import com.oms.entity.SalesOrder;
import com.oms.service.OrderService;
import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    Logger logger;

    @GetMapping
    @RequestMapping("/{customerOrderId}")
    public SalesOrder fetchSalesOrder(@PathVariable String customerOrderId) {
        logger.log(this.getClass().getName());
        return orderService.fetchOrder(customerOrderId);
    }

    @PostMapping
    public SalesOrder createSalesOrder(@RequestBody SalesOrder salesOrder) {
        logger.log(this.getClass().getName());
        return orderService.saveOrder(salesOrder);
    }
    
    @PostMapping
    @RequestMapping("/multi")
    public SalesOrder[] createMultipleOrders(@RequestBody SalesOrder[] orderArray) {
        logger.log(this.getClass().getName());
    	SalesOrder[] orders = new SalesOrder[orderArray.length];
    	int i = 0;
        for (SalesOrder order : orderArray) {
        	orders[i] = createSalesOrder(order);
        	i++;
        }
        return orders;
    }
}
