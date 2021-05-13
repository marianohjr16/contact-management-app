package com.ms3.codeexer.contactmgmtapp.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "COMMUNICATION")
public class Communication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMUNICATION_ID")
    private long communicationId;

    @Column(name = "IDENTIFICATION_ID")
    private long identificationId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "PREFERRED")
    private String preferred;

    public long getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(long communicationId) {
        this.communicationId = communicationId;
    }

    public long getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(long identificationId) {
        this.identificationId = identificationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPreferred() {
        return preferred;
    }

    public void setPreferred(String preferred) {
        this.preferred = preferred;
    }
}
