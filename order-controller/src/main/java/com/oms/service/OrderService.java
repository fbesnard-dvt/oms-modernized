package com.oms.service;

import com.oms.entity.SalesOrder;
import com.oms.repository.SalesOrderRepository;
import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    SalesOrderRepository orderRepository;

    @Autowired
    Logger logger;

    public SalesOrder saveOrder(SalesOrder salesOrder) {
        logger.log(this.getClass().getName());
        SalesOrder response = orderRepository.save(salesOrder);
        return response;
    }

    public SalesOrder fetchOrder(String customerOrderId) {
        logger.log(this.getClass().getName());
        SalesOrder response = orderRepository.findById(customerOrderId).get();
        return response;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
