package com.oms.service;

import com.oms.dto.AuthorizationRequestDto;
import com.oms.dto.AuthorizationResponseDto;
import com.oms.integrations.PaymentHttpClient;
import com.oms.util.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    PaymentHttpClient paymentHttpClient;

    PaymentService paymentService;

    @BeforeEach
    public void setUp() {
    paymentService = new PaymentService(paymentHttpClient, null);
    paymentService.setLogger(new Logger());
    }

    @Test
    public void testAuthorize() {
    AuthorizationRequestDto authorizationRequestDto = new AuthorizationRequestDto("VISA","411111",
        "11/22","123",7.00);

    AuthorizationResponseDto authorizationResponseDto = new AuthorizationResponseDto("123" ,7.00,"SUCCESS");

    Mockito.when(paymentHttpClient.authorize(authorizationRequestDto)).thenReturn(authorizationResponseDto);
    AuthorizationResponseDto responseDto = paymentService.authorize(authorizationRequestDto);

    Assertions.assertNotNull(responseDto);

    Assertions.assertEquals("SUCCESS", responseDto.getStatus());

    }

    @Test
    public void testReverseAuthorize() {
    AuthorizationRequestDto authorizationRequestDto = new AuthorizationRequestDto("VISA","411111",
        "11/22","123",7.00);

    AuthorizationResponseDto authorizationResponseDto = new AuthorizationResponseDto("123" ,7.00,"SUCCESS");

    Mockito.when(paymentHttpClient.reverseAuth(authorizationRequestDto)).thenReturn(authorizationResponseDto);
    AuthorizationResponseDto responseDto = paymentService.reverseAuth(authorizationRequestDto);

    Assertions.assertNotNull(responseDto);

    Assertions.assertEquals("SUCCESS", responseDto.getStatus());

    }
}