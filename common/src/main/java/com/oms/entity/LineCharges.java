package com.oms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LINE_CHARGE")
@Getter
@Setter
public class LineCharges {

    @Column(name = "LINE_CHARGE_ID")
    @Id
    private String lineChargeId;

    @Column(name = "TOTAL_CHARGES")
    private Double totalCharges;

    public String getLineChargeId() {
        return lineChargeId;
    }

    public void setLineChargeId(String lineChargeId) {
        this.lineChargeId = lineChargeId;
    }

    public Double getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(Double totalCharges) {
        this.totalCharges = totalCharges;
    }
}
