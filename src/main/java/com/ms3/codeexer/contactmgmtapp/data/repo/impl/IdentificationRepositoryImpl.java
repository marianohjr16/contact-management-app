package com.ms3.codeexer.contactmgmtapp.data.repo.impl;

import com.ms3.codeexer.contactmgmtapp.data.entity.Identification;
import com.ms3.codeexer.contactmgmtapp.data.repo.IdentificationRepositoryCustom;
import com.ms3.codeexer.contactmgmtapp.dto.SearchDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IdentificationRepositoryImpl implements IdentificationRepositoryCustom {
    EntityManager em;


    @Override
    public List<Identification> searchIdentificationByCriteria(SearchDTO searchDTO) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Identification> cq = cb.createQuery(Identification.class);

        Root<Identification> identification = cq.from(Identification.class);
        List<Predicate> predicates = new ArrayList<>();

        if(null != searchDTO.getFirstName() && !searchDTO.getFirstName().equals(""))
        {
            predicates.add(cb.like(identification.get("firstName"), "%" +searchDTO.getFirstName()+ "%"));
        }

        if(null != searchDTO.getLastName() && !searchDTO.getLastName().equals(""))
        {
            predicates.add(cb.like(identification.get("lastName"), "%" +searchDTO.getLastName()+ "%"));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}
