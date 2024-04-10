package com.oms.service;

import com.oms.dto.EmailRequestDto;
import com.oms.integrations.EmailHttpClient;
import com.oms.util.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    @Mock
    EmailHttpClient emailServiceHttpClient;
    EmailService emailService = new EmailService();

    @Before
    public void setUp() {
        emailService.emailServiceHttpClient = emailServiceHttpClient;
        emailService.setLogger(new Logger());
    }

    @Test
    public void sendEmail() {
        EmailRequestDto emailRequestDto = new EmailRequestDto("1234","test","test body" ,"test type");

        when(emailServiceHttpClient.sendEmail(emailRequestDto)).thenReturn("SUCCESS");

        String response = emailService.sendEmail(emailRequestDto);

        Assert.assertNotNull(response);
        Assert.assertEquals(response , "SUCCESS");

    }
}
