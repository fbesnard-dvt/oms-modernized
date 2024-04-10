package com.oms.paymentservice.dto;

import com.oms.dto.AuthorizationRequestDto;

public class PaymentServiceAuthorizeInDTO {
    private AuthorizationRequestDto authorizationRequestDto;

    public AuthorizationRequestDto getAuthorizationRequestDto() {
        return authorizationRequestDto;
    }

    public void setAuthorizationRequestDto(AuthorizationRequestDto authorizationRequestDto) {
        this.authorizationRequestDto = authorizationRequestDto;
    }

}
