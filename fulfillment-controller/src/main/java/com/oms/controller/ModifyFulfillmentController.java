/**
 * This is the ModifyFulfillmentController class. It is a REST controller that handles HTTP PATCH requests 
 * related to modifying the fulfillment of sales orders in an Order Management System (OMS).
 * 
 * It uses the Spring Framework's @RestController and @RequestMapping annotations to map web requests onto 
 * specific handler methods. It has two main methods: modifyStorePickupToShipping and modifyShippingToStorePickUp.
 * 
 * @RestController: This annotation is used at the class level to make this class a REST controller.
 * @RequestMapping("/modify/fulfillment"): This annotation is used at the class level to map web requests onto 
 * this controller using the provided URI path.
 * 
 * @Autowired: This annotation is used to auto-wire Spring managed beans into methods.
 * 
 * Methods:
 * 1. modifyStorePickupToShipping: This method is mapped to the "/shipping/items/{lineItemId}" URI using a PATCH request. 
 *    It modifies the fulfillment of a sales order from store pickup to shipping.
 * 
 * 2. modifyShippingToStorePickUp: This method is mapped to the "/store/items/{lineItemId}" URI using a PATCH request. 
 *    It modifies the fulfillment of a sales order from shipping to store pickup.
 * 
 * Each method logs the class name using a Logger and returns a SalesOrder object after modifying the fulfillment.
 */

 package com.oms.controller;

import com.oms.entity.SalesOrder;
import com.oms.service.ModifyFulfillmentService;
// import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/modify/fulfillment")
public class ModifyFulfillmentController {

    @Autowired
    ModifyFulfillmentService modifyFulfillmentService;

    // @Autowired
    // Logger logger;

    private static final Logger loggerslf4j = LoggerFactory.getLogger(ModifyFulfillmentController.class);

    /**
    * @PatchMapping
    * @RequestMapping("/shipping/items/{lineItemId}")
    * public SalesOrder modifyStorePickupToShipping(@PathVariable String lineItemId, @RequestBody SalesOrder salesOrder)
    * 
    * This method is mapped to the "/shipping/items/{lineItemId}" URI using a PATCH request. It is responsible for modifying 
    * the fulfillment of a sales order from store pickup to shipping. The method takes two parameters:
    * 
    * @PathVariable String lineItemId: This is the ID of the line item in the sales order that needs to be modified. It is 
    * passed in the URI of the PATCH request.
    * 
    * @RequestBody SalesOrder salesOrder: This is the sales order that contains the line item to be modified. It is passed 
    * in the body of the PATCH request.
    * 
    * The method returns a SalesOrder object after modifying the fulfillment. If the modification is successful, the returned 
    * SalesOrder object will reflect the changes. If the modification is not successful, the method may return the original 
    * SalesOrder object or throw an exception, depending on the implementation.
    */
    @PatchMapping
    @RequestMapping("/shipping/items/{lineItemId}")
    public SalesOrder modifyStorePickupToShipping(@PathVariable String lineItemId, @RequestBody SalesOrder salesOrder) {
        // logger.log(this.getClass().getName());
        loggerslf4j.info("modifyStorePickupToShipping method called with lineItemId: {}", lineItemId);
        SalesOrder result = null;
        try {
            result = modifyFulfillmentService.modifyToShipping(lineItemId, salesOrder);
        } catch (Exception e) {
            loggerslf4j.error("Exception occurred in modifyStorePickupToShipping: ", e);
        }
        loggerslf4j.info("modifyStorePickupToShipping method completed with result: {}", result);
        return result;
    }

    /**
     * @PatchMapping
     * @RequestMapping("/store/items/{lineItemId}")
     * public SalesOrder modifyShippingToStorePickUp(@PathVariable String lineItemId, @RequestBody SalesOrder salesOrder)
     * 
     * This method is mapped to the "/store/items/{lineItemId}" URI using a PATCH request. It is responsible for modifying 
     * the fulfillment of a sales order from shipping to store pickup. The method takes two parameters:
     * 
     * @PathVariable String lineItemId: This is the ID of the line item in the sales order that needs to be modified. It is 
     * passed in the URI of the PATCH request.
     * 
     * @RequestBody SalesOrder salesOrder: This is the sales order that contains the line item to be modified. It is passed 
     * in the body of the PATCH request.
     * 
     * The method returns a SalesOrder object after modifying the fulfillment. If the modification is successful, the returned 
     * SalesOrder object will reflect the changes. If the modification is not successful, the method may return the original 
     * SalesOrder object or throw an exception, depending on the implementation.
     */
    @PatchMapping
    @RequestMapping("/store/items/{lineItemId}")
    public SalesOrder modifyShippingToStorePickUp(@PathVariable String lineItemId, @RequestBody SalesOrder salesOrder) {
        // logger.log(this.getClass().getName());
        loggerslf4j.info("modifyShippingToStorePickUp method called with lineItemId: {}", lineItemId);
        SalesOrder result = null;
        try {
            result = modifyFulfillmentService.modifyToStorePickup(lineItemId, salesOrder);
        } catch (Exception e) {
            loggerslf4j.error("Exception occurred in modifyShippingToStorePickUp: ", e);
        }
        loggerslf4j.info("modifyShippingToStorePickUp method completed with result: {}", result);
        return result;
    }
}
