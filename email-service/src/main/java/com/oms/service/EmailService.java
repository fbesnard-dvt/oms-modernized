package com.oms.service;

import com.oms.dto.EmailRequestDto;
import com.oms.integrations.EmailHttpClient;
import com.oms.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmailService {

    @Autowired
    EmailHttpClient emailServiceHttpClient;

    @Autowired
    Logger logger;

    public String sendEmail(EmailRequestDto emailRequestDto) {
        logger.log(this.getClass().getName());
        return emailServiceHttpClient.sendEmail(emailRequestDto);
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
