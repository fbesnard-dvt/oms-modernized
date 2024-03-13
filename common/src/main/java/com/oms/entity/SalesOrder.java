package com.oms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SALES_ORDER")
@Getter @Setter
public class SalesOrder {

    @Id
    @Column(name = "CUSTOMER_ORDER_ID")
    private String customerOrderId;

    @Column(name = "PRIMARY_PHONE")
    private String primaryPhone;

    @Column(name = "CUSTOMER_EMAIL_ID")
    private String customerEmailId;

    @Column(name = "ORDER_STATUS")
    private String orderStatus;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "ORDER_DATE")
    private String orderDate;

    @Column(name = "PROFILE_ID")
    private String profileId;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ENTRY_TYPE")
    private String entryType;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "BILL_TO_ADDRESS_ID")
    private BillToAddress billToAddress;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SHIP_TO_ADDRESS_ID")
    private ShipToAddress shipToAddress;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ORDER_ID")
    private List<OrderLine> orderLines;

    /////@JoinColumn(name = "LINE_ITEM_ID")
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PAYMENT_ID")
    private PaymentInfo paymentInfo;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CHARGES_ID")
    private Charges charges;


    public String getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(String customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public BillToAddress getBillToAddress() {
        return billToAddress;
    }

    public void setBillToAddress(BillToAddress billToAddress) {
        this.billToAddress = billToAddress;
    }

    public ShipToAddress getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(ShipToAddress shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Charges getCharges() {
        return charges;
    }

    public void setCharges(Charges charges) {
        this.charges = charges;
    }
}
