package com.oms.inventorycontroller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.oms.inventorycontroller.dto.*;
import com.oms.service.InventoryService;

@RestController
@RequestMapping("/inventoryService")
public class InventoryServiceController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping(value = "fetchInventory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InventoryServiceFetchInventoryOutDTO> fetchInventory(@RequestBody InventoryServiceFetchInventoryInDTO in) {
        InventoryServiceFetchInventoryOutDTO ret = new InventoryServiceFetchInventoryOutDTO();
        ret.setRetVal(inventoryService.fetchInventory(in.getSkuId()));
        return ResponseEntity.ok(ret);
    }

}