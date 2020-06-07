package com.verros.ds.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Test {


    @PersistenceContext(unitName = "isoEntityManager")
    private EntityManager em;

    public void add (String digit){
        CheckDigit checkDigit = new CheckDigit();
        checkDigit.setDigit(digit);
         em.persist(checkDigit);
         em.flush();
    }

}
