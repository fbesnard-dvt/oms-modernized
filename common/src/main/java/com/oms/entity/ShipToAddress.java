package com.oms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SHIP_TO_ADDRESS")
@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipToAddress {

    @Column(name = "SHIP_TO_ADDRESS_ID")
    @Id
    private String shipToAddressId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS_1")
    private String address1;

    @Column(name = "ADDRESS_2")
    private String address2;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private String zipCode;

}
