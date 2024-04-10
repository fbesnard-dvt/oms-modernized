package com.oms.controller;

import com.oms.service.StoreSearchService;
import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreSearchController {

    @Autowired
    StoreSearchService storeSearchService;

    @Autowired
    Logger logger;

    @GetMapping
    @RequestMapping("/{zipCode}")
    public List<String> fetchStoresByZip(@PathVariable String zipCode) {
        logger.log(this.getClass().getName());
        return storeSearchService.fetchStoresByZipCode(zipCode);
    }


}
