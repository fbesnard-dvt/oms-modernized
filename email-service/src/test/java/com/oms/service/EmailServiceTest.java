package com.oms.service;

import com.oms.dto.EmailRequestDto;
import com.oms.integrations.EmailHttpClient;
import com.oms.util.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    EmailHttpClient emailServiceHttpClient;
    
    EmailService emailService = new EmailService();

    @BeforeEach
    public void setUp() {
        emailService.emailServiceHttpClient = emailServiceHttpClient;
        emailService.setLogger(new Logger());
    }

    @Test
    public void testSendEmail() {
        EmailRequestDto emailRequestDto = new EmailRequestDto("1234","test","test body" ,"test type");

        when(emailServiceHttpClient.sendEmail(emailRequestDto)).thenReturn("SUCCESS");

        String response = emailService.sendEmail(emailRequestDto);

        assertNotNull(response);
        assertEquals("SUCCESS", response);
    }
}