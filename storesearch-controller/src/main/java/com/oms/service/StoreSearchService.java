package com.oms.service;

import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class StoreSearchService {
    @Autowired
    Logger logger;

    private AtomicInteger useCnt = new AtomicInteger();

    public List<String> fetchStoresByZipCode(String zipCode) {
        logger.log(this.getClass().getName());
        List<String> storesList = new ArrayList<>();
        storesList.add("281");
        storesList.add("282");
        storesList.add("283");
        storesList.add("284");
        storesList.add(String.format("%d", useCnt.incrementAndGet()));
        return storesList;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
