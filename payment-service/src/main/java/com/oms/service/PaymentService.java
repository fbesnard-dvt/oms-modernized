package com.oms.service;

import com.oms.dto.AuthorizationRequestDto;
import com.oms.dto.AuthorizationResponseDto;
import com.oms.integrations.PaymentHttpClient;
import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * PaymentService is a service class that handles payment operations.
 * It uses two different HTTP clients for VISA and AMEX payments.
 */
@Service
@Transactional
public class PaymentService {

    private PaymentHttpClient visaPaymentHttpClient;
    private PaymentHttpClient amexPaymentHttpClient;

    @Autowired
    Logger logger;

    /**
     * Constructs a new PaymentService with the given HTTP clients.
     *
     * @param visaPaymentHttpClient  the HTTP client for VISA payments
     * @param amexPaymentHttpClient  the HTTP client for AMEX payments
     */
    @Autowired
    public PaymentService(PaymentHttpClient visaPaymentHttpClient, PaymentHttpClient amexPaymentHttpClient) {
        this.visaPaymentHttpClient = visaPaymentHttpClient;
        this.amexPaymentHttpClient = amexPaymentHttpClient;
    }

    /**
     * Authorizes a payment.
     *
     * @param authorizationRequestDto  the authorization request data
     * @return the authorization response data
     */
    public AuthorizationResponseDto authorize(AuthorizationRequestDto authorizationRequestDto) {
        try {
            // Log the class name
            logger.log(this.getClass().getName());

            // If the card type is VISA, use the VISA HTTP client to authorize the payment
            // Otherwise, use the AMEX HTTP client
            if (authorizationRequestDto.getCardType().equals("VISA")) {
                return visaPaymentHttpClient.authorize(authorizationRequestDto);
            } else {
                return amexPaymentHttpClient.authorize(authorizationRequestDto);
            }
        } catch (Exception e) {
            // Log the exception and rethrow it as a RuntimeException
            logger.error("Error during authorization", e);
            throw new RuntimeException("Error during authorization", e);
        }
    }

    /**
     * Reverses a previous authorization.
     *
     * @param authorizationRequestDto  the authorization request data
     * @return the authorization response data
     */
    public AuthorizationResponseDto reverseAuth(AuthorizationRequestDto authorizationRequestDto) {
        try {
            // Log the class name
            logger.log(this.getClass().getName());

            // If the card type is VISA, use the VISA HTTP client to reverse the authorization
            // Otherwise, use the AMEX HTTP client
            if (authorizationRequestDto.getCardType().equals("VISA")) {
                return visaPaymentHttpClient.reverseAuth(authorizationRequestDto);
            } else {
                return amexPaymentHttpClient.reverseAuth(authorizationRequestDto);
            }
        } catch (Exception e) {
            // Log the exception and rethrow it as a RuntimeException
            logger.error("Error during reverse authorization", e);
            throw new RuntimeException("Error during reverse authorization", e);
        }
    }

    /**
     * Sets the logger to be used by this service.
     *
     * @param logger  the logger
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}