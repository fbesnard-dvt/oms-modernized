package com.oms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CHARGES")
@Getter @Setter
public class Charges {

    @Column(name = "CHARGES_ID")
    @Id
    private String chargesId;

    @Column(name = "LINE_SUB_TOTAL")
    private Double lineSubTotal;

    @Column(name = "TOTAL_CHARGES")
    private Double totalCharges;

    @Column(name = "SALES_TAX")
    private Double salesTax;

    @Column(name = "GRAND_TOTAL")
    private Double grandTotal;


    public String getChargesId() {
        return chargesId;
    }

    public void setChargesId(String chargesId) {
        this.chargesId = chargesId;
    }

    public Double getLineSubTotal() {
        return lineSubTotal;
    }

    public void setLineSubTotal(Double lineSubTotal) {
        this.lineSubTotal = lineSubTotal;
    }

    public Double getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(Double totalCharges) {
        this.totalCharges = totalCharges;
    }

    public Double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(Double salesTax) {
        this.salesTax = salesTax;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
