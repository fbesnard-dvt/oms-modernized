package com.oms.integrations;

import com.oms.dto.EmailRequestDto;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class EmailHttpClientImpl implements EmailHttpClient {
    private AtomicInteger useCnt = new AtomicInteger();

    @Override
    public String sendEmail(EmailRequestDto emailRequestDto) {
        return String.format("SUCCESS %d", useCnt.incrementAndGet());
    }
}
