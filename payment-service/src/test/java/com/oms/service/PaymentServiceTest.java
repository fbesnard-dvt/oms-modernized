package com.oms.service;

import com.oms.dto.AuthorizationRequestDto;
import com.oms.dto.AuthorizationResponseDto;
import com.oms.integrations.PaymentHttpClient;
import com.oms.util.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @Mock
    PaymentHttpClient paymentHttpClient;

    PaymentService paymentService;

    @Before
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

        Assert.assertNotNull(responseDto);

        Assert.assertEquals(responseDto.getStatus() ,"SUCCESS");

    }

    @Test
    public void testReverseAuthorize() {
        AuthorizationRequestDto authorizationRequestDto = new AuthorizationRequestDto("VISA","411111",
                "11/22","123",7.00);

        AuthorizationResponseDto authorizationResponseDto = new AuthorizationResponseDto("123" ,7.00,"SUCCESS");

        Mockito.when(paymentHttpClient.reverseAuth(authorizationRequestDto)).thenReturn(authorizationResponseDto);
        AuthorizationResponseDto responseDto = paymentService.reverseAuth(authorizationRequestDto);

        Assert.assertNotNull(responseDto);

        Assert.assertEquals(responseDto.getStatus() ,"SUCCESS");

    }


}
