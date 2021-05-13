package com.ms3.codeexer.contactmgmtapp.data.entity;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name ="ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private long addressId;

    @Column(name = "IDENTIFICATION_ID")
    private long identificationId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "STREET")
    private String street;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIPCODE")
    private String zipCode;

    public Address() {}

    public Address(long addressId, long identificationId, String type, String number, String street, String unit, String city, String state, String zipCode) {
        this.addressId = addressId;
        this.identificationId = identificationId;
        this.type = type;
        this.number = number;
        this.street = street;
        this.unit = unit;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public long getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(long identificationId) {
        this.identificationId = identificationId;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }
//
//    public Identification getIdentification() {
//        return identification;
//    }
//
//    public void setIdentification(Identification identification) {
//        this.identification = identification;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
