package com.oms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_LINE")
@Getter @Setter
public class OrderLine {

    @Column(name = "LINE_ITEM_ID")
    @Id
    private String lineItemId;
    
    @Column(name = "CUSTOMER_ORDER_ID")
    private String customerOrderId;

	@Column(name = "SHIP_NODE")
    private String shipNode;

    @Column(name = "SHIP_NODE_DESC")
    private String shipNodeDescription;

    @Column(name = "LEVEL_OF_SERVICE")
    private String levelOfService;

    @Column(name = "PRIME_LINE_NO")
    private String primeLineNumber;

    @Column(name = "SUB_LINE_NO")
    private String subLineNumber;

    @Column(name = "CUSTOMER_SKU")
    private String customerSKU;

    @Column(name = "SKU_DESCRIPTION")
    private String skuDescription;

    @Column(name = "EST_ARRIVAL_DATE")
    private String estimatedArrivalDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "RESHIPPED_BEFORE")
    private String reshippedBefore;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SHIP_TO_ADDRESS_ID")
    private ShipToAddress shipToAddress;

    public LineCharges getCharges() {
        return charges;
    }

    public void setCharges(LineCharges charges) {
        this.charges = charges;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "LINE_CHARGE_ID")
    private LineCharges charges;

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }
    
    public String getCustomerOrderId() {
 		return customerOrderId;
 	}

 	public void setCustomerOrderId(String customerOrderId) {
 		this.customerOrderId = customerOrderId;
 	}

    public String getShipNode() {
        return shipNode;
    }

    public void setShipNode(String shipNode) {
        this.shipNode = shipNode;
    }

    public String getShipNodeDescription() {
        return shipNodeDescription;
    }

    public void setShipNodeDescription(String shipNodeDescription) {
        this.shipNodeDescription = shipNodeDescription;
    }

    public String getLevelOfService() {
        return levelOfService;
    }

    public void setLevelOfService(String levelOfService) {
        this.levelOfService = levelOfService;
    }

    public String getPrimeLineNumber() {
        return primeLineNumber;
    }

    public void setPrimeLineNumber(String primeLineNumber) {
        this.primeLineNumber = primeLineNumber;
    }

    public String getSubLineNumber() {
        return subLineNumber;
    }

    public void setSubLineNumber(String subLineNumber) {
        this.subLineNumber = subLineNumber;
    }

    public String getCustomerSKU() {
        return customerSKU;
    }

    public void setCustomerSKU(String customerSKU) {
        this.customerSKU = customerSKU;
    }

    public String getSkuDescription() {
        return skuDescription;
    }

    public void setSkuDescription(String skuDescription) {
        this.skuDescription = skuDescription;
    }

    public String getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(String estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReshippedBefore() {
        return reshippedBefore;
    }

    public void setReshippedBefore(String reshippedBefore) {
        this.reshippedBefore = reshippedBefore;
    }

    public ShipToAddress getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(ShipToAddress shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

}
