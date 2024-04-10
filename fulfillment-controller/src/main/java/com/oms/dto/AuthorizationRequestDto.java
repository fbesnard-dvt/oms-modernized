package com.oms.dto;

import java.util.Objects;

public class AuthorizationRequestDto {
    private String cardType;
    private String cardNumber;
    private String cardExpiryDate;
    private String secureCode;
    private Double amount;

    public AuthorizationRequestDto(String cardType, String cardNumber, String cardExpiryDate, String secureCode, Double amount) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.secureCode = secureCode;
        this.amount = amount;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getSecureCode() {
        return secureCode;
    }

    public void setSecureCode(String secureCode) {
        this.secureCode = secureCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, cardNumber, cardExpiryDate, secureCode, amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }
        AuthorizationRequestDto dto = (AuthorizationRequestDto)obj;
        return Objects.equals(this.cardType, dto.cardType)
                && Objects.equals(this.cardNumber, dto.cardNumber)
                && Objects.equals(this.cardExpiryDate, dto.cardExpiryDate)
                && Objects.equals(this.secureCode, dto.secureCode)
                && Objects.equals(this.amount, dto.amount);
    }
}
