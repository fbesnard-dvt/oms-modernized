package com.oms.integrations;

import com.oms.dto.AuthorizationRequestDto;
import com.oms.dto.AuthorizationResponseDto;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractPaymentHttpClient implements PaymentHttpClient {
    private AtomicInteger useCnt = new AtomicInteger();
    private double authAmount;

    public AbstractPaymentHttpClient(double authAmount) {
        this.authAmount = authAmount;
    }

    @Override
    public AuthorizationResponseDto authorize(AuthorizationRequestDto authorizationRequestDto) {
        return new AuthorizationResponseDto("123", authAmount, String.format("SUCCESS %d", useCnt.incrementAndGet()));
    }

    @Override
    public AuthorizationResponseDto reverseAuth(AuthorizationRequestDto authorizationRequestDto) {
        return new AuthorizationResponseDto("123", authAmount, String.format("SUCCESS %d", useCnt.incrementAndGet()));
    }
}
