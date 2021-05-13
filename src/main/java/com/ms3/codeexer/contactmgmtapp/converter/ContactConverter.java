package com.ms3.codeexer.contactmgmtapp.converter;

import com.ms3.codeexer.contactmgmtapp.data.entity.Address;
import com.ms3.codeexer.contactmgmtapp.data.entity.Communication;
import com.ms3.codeexer.contactmgmtapp.data.entity.Identification;
import com.ms3.codeexer.contactmgmtapp.dto.AddressDTO;
import com.ms3.codeexer.contactmgmtapp.dto.CommunicationDTO;
import com.ms3.codeexer.contactmgmtapp.dto.ContactDTO;
import com.ms3.codeexer.contactmgmtapp.dto.IdentificationDTO;
import org.springframework.stereotype.Service;

@Service
public class ContactConverter {
    public ContactDTO convertToContactDTO(final Identification identification) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setIdentification(
                new IdentificationDTO(identification.getIdentificationId(),
                        identification.getFirstName(),
                        identification.getLastName(),
                        DateStringConverter.convertToDateString(identification.getDob()),
                        identification.getGender(),
                        identification.getTitle()));
        for(Address address : identification.getAddressList()) {
            contactDTO.getAddress().add(
                    new AddressDTO(address.getAddressId(),
                            address.getType(),
                            address.getNumber(),
                            address.getStreet(),
                            address.getUnit(),
                            address.getCity(),
                            address.getState(),
                            address.getZipCode()));
        }

        for(Communication commModel : identification.getCommunicationList()) {
            contactDTO.getCommunication().add(
                    new CommunicationDTO(commModel.getCommunicationId(),
                            commModel.getType(),
                            commModel.getValue(),
                            commModel.getPreferred()));
        }
        return contactDTO;
    }

    public Identification convertToIdentificationEntity(final ContactDTO contactDTO) {
        Identification identificationModel = new Identification();
        if(contactDTO.getIdentification().getIdentificationId() > 0)
        {
            identificationModel.setIdentificationId(contactDTO.getIdentification().getIdentificationId());
        }
        identificationModel.setFirstName(contactDTO.getIdentification().getFirstName());
        identificationModel.setLastName(contactDTO.getIdentification().getLastName());
        identificationModel.setDob(DateStringConverter.convertToSqlDate(contactDTO.getIdentification().getDob()));
        identificationModel.setGender(contactDTO.getIdentification().getGender());
        identificationModel.setTitle(contactDTO.getIdentification().getTitle());

        for(AddressDTO addressDTO : contactDTO.getAddress()) {
            Address addressModel = new Address();
            addressModel.setAddressId(addressDTO.getAddressId());
            System.out.println("Updating identification: "+contactDTO.getIdentification().getIdentificationId());
            if(contactDTO.getIdentification().getIdentificationId() > 0) {
                addressModel.setIdentificationId(contactDTO.getIdentification().getIdentificationId());
            }
            addressModel.setType(addressDTO.getType());
            addressModel.setNumber(addressDTO.getNumber());
            addressModel.setStreet(addressDTO.getStreet());
            addressModel.setUnit(addressDTO.getUnit());
            addressModel.setCity(addressDTO.getCity());
            addressModel.setState(addressDTO.getState());
            addressModel.setZipCode(addressDTO.getZipCode());
            identificationModel.getAddressList().add(addressModel);
        }

        for(CommunicationDTO commDTO : contactDTO.getCommunication()) {
            Communication commModel = new Communication();
            commModel.setCommunicationId(commDTO.getCommunicationId());
            if(contactDTO.getIdentification().getIdentificationId() > 0) {
                commModel.setIdentificationId(contactDTO.getIdentification().getIdentificationId());
            }
            commModel.setType(commDTO.getType());
            commModel.setValue(commDTO.getValue());
            commModel.setPreferred(commDTO.getPreferred());
            identificationModel.getCommunicationList().add(commModel);
        }

        return identificationModel;
    }
}
