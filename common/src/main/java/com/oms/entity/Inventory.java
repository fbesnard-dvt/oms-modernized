package com.oms.entity;

import javax.persistence.*;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

    @Column(name = "SKU_ID")
    @Id
    private String skuId;

    @Column(name = "STORE_ID")
    private String storeId;

    @Column(name = "QTY")
    private int quantity;

    public Inventory() {
    }

    public Inventory(String skuId, String storeId, int quantity) {
        this.skuId = skuId;
        this.storeId = storeId;
        this.quantity = quantity;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
