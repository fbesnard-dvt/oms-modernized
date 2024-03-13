package com.oms.controller;

import com.oms.entity.Inventory;
import com.oms.service.InventoryService;
import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    Logger logger;

    @GetMapping
    @RequestMapping("/{skuId}")
    public Inventory fetchInventory(@PathVariable String skuId) {
        logger.log(this.getClass().getName());
        return inventoryService.fetchInventory(skuId);
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        logger.log(this.getClass().getName());
        return inventoryService.createInventory(inventory);
    }
    
    @PostMapping
    @RequestMapping("/multi-create")
    public Inventory[] createMulti(@RequestBody Inventory[] invArray) {
    	Inventory[] createdInv = new Inventory[invArray.length];
    	int i = 0;
        logger.log(this.getClass().getName());
        for (Inventory inv : invArray) {
        	createdInv[i] = createInventory(inv);
        	i++;
        }
        return createdInv;
    }


}
