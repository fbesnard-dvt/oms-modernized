package com.oms.service;

import com.oms.entity.Shipping;
import com.oms.repository.ShippingRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShippingServiceTest {

    @Mock
    ShippingRepository shippingRepository;

    ShippingService shippingService = new ShippingService();

    @BeforeEach
    public void setUp() {
        shippingService.shippingRepository = shippingRepository;
        // shippingService.setLogger(new Logger());
    }

    @Test
    public void validateShipping() {
        Shipping shipping = new Shipping("123", 3.00,5.00,7.00);

        when(shippingRepository.findById("123")).thenReturn(java.util.Optional.of(shipping));

        Shipping response = shippingService.fetchShippingCharges("123");

        Assertions.assertNotNull(response);
    }
}