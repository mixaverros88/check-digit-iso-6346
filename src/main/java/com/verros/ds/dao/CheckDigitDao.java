package com.verros.ds.dao;

import com.verros.ds.entities.CheckDigit;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class CheckDigitDao implements Dao<CheckDigit> {


  @PersistenceContext(unitName = "isoEntityManager")
  private EntityManager em;

  @Override
  public void add(CheckDigit checkDigit) {
    em.persist(checkDigit);
    em.flush();
  }

}
