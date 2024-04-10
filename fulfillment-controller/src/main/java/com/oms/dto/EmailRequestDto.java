package com.oms.dto;

public class EmailRequestDto {

    private String salesOrderNumber;
    private String messageTitle;
    private String messageBody;
    private String emailType;


    public EmailRequestDto(String salesOrderNumber, String messageTitle, String messageBody, String emailType) {
        this.salesOrderNumber = salesOrderNumber;
        this.messageTitle = messageTitle;
        this.messageBody = messageBody;
        this.emailType = emailType;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }
}
