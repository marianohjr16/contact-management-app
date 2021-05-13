package com.ms3.codeexer.contactmgmtapp.data.repo;

import com.ms3.codeexer.contactmgmtapp.data.entity.Identification;
import com.ms3.codeexer.contactmgmtapp.dto.SearchDTO;

import java.util.List;

public interface IdentificationRepositoryCustom {
    List<Identification> searchIdentificationByCriteria(SearchDTO searchDTO);
}
