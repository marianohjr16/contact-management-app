package com.ms3.codeexer.contactmgmtapp.data.repo;

import com.ms3.codeexer.contactmgmtapp.data.entity.Identification;
import com.ms3.codeexer.contactmgmtapp.dto.SearchDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IdentificationRepository extends CrudRepository<Identification, Long>, IdentificationRepositoryCustom {
    public List<Identification> getIdentificationsByFirstNameIsLikeOrLastNameIsLike(String firstName, String lastName);
    public List<Identification> findAllByFirstNameLikeAndLastNameLike(String firstName, String lastName);
}
