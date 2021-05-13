package com.ms3.codeexer.contactmgmtapp.data.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "IDENTIFICATION")
public class Identification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFICATION_ID")
    private long identificationId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name="DOB")
    private Date dob;

    @Column(name = "GENDER")
    private String gender;


    @Column(name = "TITLE")
    private String title;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "IDENTIFICATION_ID")
    List<Address> addressList;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "IDENTIFICATION_ID")
    List<Communication> communicationList;

    public long getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(long identificationId) {
        this.identificationId = identificationId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Address> getAddressList() {
        if(addressList == null) {
            this.addressList = new ArrayList<>();
        }
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Communication> getCommunicationList() {
        if(this.communicationList == null) {
            this.communicationList = new ArrayList<>();
        }
        return communicationList;
    }

    public void setCommunicationList(List<Communication> communicationList) {
        this.communicationList = communicationList;
    }
}
