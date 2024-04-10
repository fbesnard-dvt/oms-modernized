package com.oms.service;

import com.oms.entity.Shipping;
import com.oms.repository.ShippingRepository;
import com.oms.util.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShippingServiceTest {

    @Mock
    ShippingRepository shippingRepository;

    ShippingService shippingService = new ShippingService();

    @Before
    public void setUp() {
        shippingService.shippingRepository = shippingRepository;
        // shippingService.setLogger(new Logger());
    }

    @Test
    public void validateShipping() {
        Shipping shipping = new Shipping("123", 3.00,5.00,7.00);

        when(shippingRepository.findById("123")).thenReturn(java.util.Optional.of(shipping));

        Shipping response = shippingService.fetchShippingCharges("123");

        Assert.assertNotNull(response);

    }
}
