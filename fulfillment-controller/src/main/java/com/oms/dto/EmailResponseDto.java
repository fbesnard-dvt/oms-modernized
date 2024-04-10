package com.oms.dto;

public class EmailResponseDto {
    private String retVal;

    public EmailResponseDto() {
    }   

    public EmailResponseDto(String retVal) {
        this.retVal = retVal;
    }

    public String getRetVal() {
        return retVal;
    }
}
