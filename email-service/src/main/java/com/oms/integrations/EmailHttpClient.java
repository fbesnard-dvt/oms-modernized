package com.oms.integrations;

import com.oms.dto.EmailRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface EmailHttpClient {
    String sendEmail(EmailRequestDto emailRequestDto);
}
