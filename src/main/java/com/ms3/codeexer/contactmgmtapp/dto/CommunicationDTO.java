package com.ms3.codeexer.contactmgmtapp.dto;

public class CommunicationDTO {
    private long communicationId;
    private String type;
    private String value;
    private String preferred;

    public CommunicationDTO(long communicationId, String type, String value, String preferred) {
        this.communicationId = communicationId;
        this.type = type;
        this.value = value;
        this.preferred = preferred;
    }

    public long getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(long communicationId) {
        this.communicationId = communicationId;
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
