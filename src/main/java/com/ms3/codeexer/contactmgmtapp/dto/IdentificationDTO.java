package com.ms3.codeexer.contactmgmtapp.dto;

public class IdentificationDTO {
    private long identificationId;
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String title;

    public IdentificationDTO(long identificationId, String firstName, String lastName, String dob, String gender, String title) {
        this.identificationId = identificationId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.title = title;
    }

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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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
}
