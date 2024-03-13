package com.oms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT_INFO")
@Getter @Setter
public class PaymentInfo {

    @Column(name = "PAYMENT_ID")
    @Id
    private String paymentId;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

    @Column(name = "CARD_TYPE")
    private String cardType;

    @Column(name = "AUTHORIZED_AMOUNT")
    private Double authorizedAmount;

    @Column(name = "COLLECTED_AMOUNT")
    private Double collectedAmount;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Double getAuthorizedAmount() {
        return authorizedAmount;
    }

    public void setAuthorizedAmount(Double authorizedAmount) {
        this.authorizedAmount = authorizedAmount;
    }

    public Double getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(Double collectedAmount) {
        this.collectedAmount = collectedAmount;
    }
}
