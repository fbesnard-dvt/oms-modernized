package com.oms.controller;

import com.oms.entity.Shipping;
import com.oms.service.ShippingService;
import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipping")
public class ShippingPriceController {

    @Autowired
    ShippingService shippingService;

    @Autowired
    Logger logger;

    @GetMapping
    @RequestMapping("/{skuId}")
    public Shipping fetchSalesOrder(@PathVariable String skuId) {
        logger.log(this.getClass().getName());
        return shippingService.fetchShippingCharges(skuId);
    }

    @PostMapping
    public Shipping createShipping(@RequestBody Shipping shipping) {
        logger.log(this.getClass().getName());
        return shippingService.createShipping(shipping);
    }

}
