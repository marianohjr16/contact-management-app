package com.ms3.codeexer.contactmgmtapp.dto;

import com.ms3.codeexer.contactmgmtapp.data.entity.Identification;

import java.util.ArrayList;
import java.util.List;

public class ContactDTO {
    private IdentificationDTO identification;
    private List<AddressDTO> address;
    private List<CommunicationDTO> communication;

    public ContactDTO() {
    }

    public IdentificationDTO getIdentification() {
        return identification;
    }

    public void setIdentification(IdentificationDTO identification) {
        this.identification = identification;
    }

    public List<AddressDTO> getAddress() {
        if(this.address == null) {
            this.address = new ArrayList<>();
        }
        return address;
    }

    public void setAddress(List<AddressDTO> address) {
        this.address = address;
    }

    public List<CommunicationDTO> getCommunication() {
        if(this.communication == null) {
            this.communication = new ArrayList<>();
        }
        return communication;
    }

    public void setCommunication(List<CommunicationDTO> communication) {
        this.communication = communication;
    }
}
