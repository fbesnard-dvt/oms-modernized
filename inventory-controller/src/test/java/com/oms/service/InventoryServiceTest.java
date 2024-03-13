package com.oms.service;

import com.oms.entity.Inventory;
import com.oms.util.Logger;

import org.apache.geode.cache.Region;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceTest {

    @Mock
    Region<String, Inventory> inventoryRegion;
    InventoryService inventoryService = new InventoryService();

    @Before
    public void setUp() {
        inventoryService.inventoryRegion = inventoryRegion;
        inventoryService.setLogger(new Logger());
    }

    @Test
    public void fetchInventory() {
        Inventory inventory = new Inventory("123", "281", 10);

        when(inventoryRegion.get("123")).thenReturn(inventory);

         Inventory response = inventoryService.fetchInventory("123");

        Assert.assertNotNull(response);
        Assert.assertEquals(response.getQuantity() , 10);

    }

}
