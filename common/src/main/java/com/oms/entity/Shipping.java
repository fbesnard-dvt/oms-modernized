package com.oms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPPING")
public class Shipping {

    @Id
    @Column(name = "SKU_ID")
    private String skuId;

    @Column(name = "STANDARD_SHIPPING")
    private Double standardShipping;

    @Column(name = "EXPEDITED_SHIPPING")
    private Double expeditedShipping;

    @Column(name = "EXPRESS_SHIPPING")
    private Double expressShipping;

    public Shipping(){}

    public Shipping(String skuId, Double standardShipping, Double expeditedShipping, Double expressShipping) {
        this.skuId = skuId;
        this.standardShipping = standardShipping;
        this.expeditedShipping = expeditedShipping;
        this.expressShipping = expressShipping;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Double getStandardShipping() {
        return standardShipping;
    }

    public void setStandardShipping(Double standardShipping) {
        this.standardShipping = standardShipping;
    }

    public Double getExpeditedShipping() {
        return expeditedShipping;
    }

    public void setExpeditedShipping(Double expeditedShipping) {
        this.expeditedShipping = expeditedShipping;
    }

    public Double getExpressShipping() {
        return expressShipping;
    }

    public void setExpressShipping(Double expressShipping) {
        this.expressShipping = expressShipping;
    }
}
