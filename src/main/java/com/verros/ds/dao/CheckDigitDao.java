package com.verros.ds.dao;

import com.verros.ds.entities.CheckDigitJpo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public class CheckDigitDao implements Dao<CheckDigitJpo> {


  @PersistenceContext(unitName = "isoEntityManager")
  private EntityManager em;

  @Override
  public void add(CheckDigitJpo checkDigitJpo) {
    em.persist(checkDigitJpo);
    em.flush();
  }

  @Override
  public <T> List<T> getAll(Class<T> t) {
    String sqlquery = String.format("select e from %s e", t.getSimpleName());
    TypedQuery<T> query = em.createQuery(sqlquery, t);
    return query.getResultList();
  }

}
