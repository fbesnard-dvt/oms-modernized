package com.oms.service;

import com.oms.entity.Inventory;
import com.oms.util.Logger;
import org.apache.geode.cache.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InventoryService {

    @Autowired
    @Qualifier("inventoryRegion")
    Region<String, Inventory> inventoryRegion;

    @Autowired
    Logger logger;

    public Inventory fetchInventory(String skuId) {
        logger.log(this.getClass().getName());
        return inventoryRegion.get(skuId);
    }

    public Inventory createInventory(Inventory inventory) {
        logger.log(this.getClass().getName());
        inventoryRegion.put(inventory.getSkuId(), inventory);
        return fetchInventory(inventory.getSkuId());
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
