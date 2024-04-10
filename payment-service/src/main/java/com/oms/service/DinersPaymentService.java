package com.oms.service;

import com.oms.dto.AuthorizationRequestDto;
import com.oms.dto.AuthorizationResponseDto;
import com.oms.integrations.PaymentHttpClient;
import com.oms.integrations.PaymentQualifier;
import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DinersPaymentService {

    @Autowired
    @PaymentQualifier("diners")
    PaymentHttpClient dinersPaymentHttpClient;

    @Autowired
    Logger logger;

    public AuthorizationResponseDto authorize(AuthorizationRequestDto authorizationRequestDto) {
        logger.log(this.getClass().getName());
        return dinersPaymentHttpClient.authorize(authorizationRequestDto);
    }

    public AuthorizationResponseDto reverseAuth(AuthorizationRequestDto authorizationRequestDto) {
        logger.log(this.getClass().getName());
        return dinersPaymentHttpClient.reverseAuth(authorizationRequestDto);
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
