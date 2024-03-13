package com.oms.inventorycontroller.dto;

import com.oms.entity.Inventory;

public class InventoryServiceFetchInventoryOutDTO {
    private Inventory retVal;
    
    
    public Inventory getRetVal() {
        return retVal;
    }

    public void setRetVal(Inventory retVal) {
        this.retVal = retVal;
    }
    
}