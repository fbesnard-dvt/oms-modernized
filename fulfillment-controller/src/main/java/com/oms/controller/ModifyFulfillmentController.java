package com.oms.controller;

import com.oms.entity.SalesOrder;
import com.oms.service.ModifyFulfillmentService;
import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modify/fulfillment")
public class ModifyFulfillmentController {

    @Autowired
    ModifyFulfillmentService modifyFulfillmentService;

    @Autowired
    Logger logger;

    @PatchMapping
    @RequestMapping("/shipping/items/{lineItemId}")
    public SalesOrder modifyStorePickupToShipping(@PathVariable String lineItemId, @RequestBody SalesOrder salesOrder) {
        logger.log(this.getClass().getName());
        return modifyFulfillmentService.modifyToShipping(lineItemId, salesOrder);
    }

    @PatchMapping
    @RequestMapping("/store/items/{lineItemId}")
    public SalesOrder modifyShippingToStorePickUp(@PathVariable String lineItemId, @RequestBody SalesOrder salesOrder) {
        logger.log(this.getClass().getName());
        return modifyFulfillmentService.modifyToStorePickup(lineItemId, salesOrder);
    }

}
