package com.oms.service;

import com.oms.entity.Shipping;
import com.oms.repository.ShippingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    private static final Logger logger = LoggerFactory.getLogger(ShippingService.class);

    public Shipping fetchShippingCharges(String skuId) {
        logger.info("Fetching shipping charges for SKU ID: {}", skuId);
        Shipping shipping = fetchShippingChargesFromRepository(skuId);
        if (shipping == null) {
            logger.warn("No shipping charges found for SKU ID: {}", skuId);
        } else {
            logger.info("Shipping charges for SKU ID {}: {}", skuId, shipping);
        }
        return shipping;
    }

    private Shipping fetchShippingChargesFromRepository(String skuId) {
        return shippingRepository.findById(skuId).orElse(null);
    }

    public Shipping createShipping(Shipping shipping) {
        logger.info("Creating shipping: {}", shipping);
        Shipping savedShipping = shippingRepository.save(shipping);
        logger.info("Created shipping: {}", savedShipping);
        return savedShipping;
    }
}