package com.oms.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import com.oms.util.Logger;

@ExtendWith(MockitoExtension.class)
public class StoreSearchServiceTest {

    StoreSearchService storeSearchService = new StoreSearchService();

    @BeforeEach
    public void setUp() {
        storeSearchService.setLogger(new Logger());
    }

    @Test
    public void testStoreSearch() {
        List<String> response = storeSearchService.fetchStoresByZipCode("55347");
        Assertions.assertNotNull(response);
    }
}