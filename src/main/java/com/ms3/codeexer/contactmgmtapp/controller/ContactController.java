package com.ms3.codeexer.contactmgmtapp.controller;

import com.ms3.codeexer.contactmgmtapp.converter.ContactConverter;
import com.ms3.codeexer.contactmgmtapp.data.entity.Identification;
import com.ms3.codeexer.contactmgmtapp.data.repo.IdentificationRepository;
import com.ms3.codeexer.contactmgmtapp.dto.ContactDTO;
import com.ms3.codeexer.contactmgmtapp.dto.MessageDTO;
import com.ms3.codeexer.contactmgmtapp.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/rest/identification")
public class ContactController {

    private IdentificationRepository identificationRepository;
    private ContactConverter contactConverter;

    @Autowired
    public ContactController(IdentificationRepository identificationRepository, ContactConverter contactConverter) {
        this.identificationRepository = identificationRepository;
        this.contactConverter = contactConverter;
    }

    protected ContactController() {
    }

    @GetMapping
    public List<ContactDTO> getAllContacts() {
        System.out.println("Getting all contacts....");
        List<ContactDTO> contactRecDTOList = new ArrayList<>();
        identificationRepository.findAll().forEach(identification -> {
            contactRecDTOList.add(contactConverter.convertToContactDTO(identification));
        });

        return contactRecDTOList;
    }

    @GetMapping
    @RequestMapping(path = "/{identificationId}")
    public ContactDTO getContactRecord(@PathVariable(value = "identificationId") long identificationId) {
        ContactDTO contactDTO = new ContactDTO();
        Optional<Identification> optIdentification = identificationRepository.findById(identificationId);
        if(optIdentification.isPresent())
        {
            contactDTO = contactConverter.convertToContactDTO(optIdentification.get());
        }
        else
        {
            throw new NoSuchElementException("No Contact Record found with ID: "+identificationId);
        }
        return contactDTO;
    }

    @PostMapping
    @RequestMapping(path = "/search")
    public List<ContactDTO> searchByCriteria(@RequestBody @Validated SearchDTO searchDTO) {
        List<ContactDTO> contactRecDTOList = new ArrayList<>();
        identificationRepository.findAllByFirstNameLikeAndLastNameLike("%"+searchDTO.getFirstName()+"%", "%"+searchDTO.getLastName()+"%").forEach(identification -> {
            contactRecDTOList.add(contactConverter.convertToContactDTO(identification));
        });
        return contactRecDTOList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Identification createContact(@RequestBody @Validated ContactDTO contactDTO) {
        Identification identification = identificationRepository.save(contactConverter.convertToIdentificationEntity(contactDTO));
        return identification;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public MessageDTO deleteContact(@RequestBody @Validated ContactDTO contactDTO) {
        Optional<Identification> optIdentification = identificationRepository.findById(contactDTO.getIdentification().getIdentificationId());
        if(optIdentification.isPresent())
        {
            identificationRepository.delete(optIdentification.get());
            return new MessageDTO(HttpStatus.OK.toString(), "ID: "+contactDTO.getIdentification().getIdentificationId()+ " successfully deleted.");
        }
        else
        {
            throw new NoSuchElementException("No Contact Record found with ID: "+contactDTO.getIdentification().getIdentificationId());
        }
    }


    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex exception
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public MessageDTO return400(NoSuchElementException ex) {
        return new MessageDTO(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
    }

}
