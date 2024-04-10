package com.oms.integrations;

import com.oms.dto.AuthorizationRequestDto;
import com.oms.dto.AuthorizationResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface PaymentHttpClient {
    public AuthorizationResponseDto authorize(AuthorizationRequestDto authorizationRequestDto);
    public AuthorizationResponseDto reverseAuth(AuthorizationRequestDto authorizationRequestDto);
}
