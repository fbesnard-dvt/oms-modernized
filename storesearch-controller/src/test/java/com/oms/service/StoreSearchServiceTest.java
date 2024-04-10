package com.oms.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import com.oms.util.Logger;


@RunWith(MockitoJUnitRunner.class)
public class StoreSearchServiceTest {

    StoreSearchService storeSearchService = new StoreSearchService();

    @Before
    public void setUp() {
        storeSearchService.setLogger(new Logger());
    }

    @Test
    public void testStoreSearch() {

        List<String> response = storeSearchService.fetchStoresByZipCode("55347");

        Assert.assertNotNull(response);

    }
}
