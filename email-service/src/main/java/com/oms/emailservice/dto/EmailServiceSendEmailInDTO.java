package com.oms.emailservice.dto;

import com.oms.dto.EmailRequestDto;

public class EmailServiceSendEmailInDTO {
    private EmailRequestDto emailRequestDto;

    public EmailRequestDto getEmailRequestDto() {
        return emailRequestDto;
    }

    public void setEmailRequestDto(EmailRequestDto emailRequestDto) {
        this.emailRequestDto = emailRequestDto;
    }

}
