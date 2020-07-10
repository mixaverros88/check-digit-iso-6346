package com.verros.ds.dao;

import com.verros.ds.entities.CheckDigitJpo;
import com.verros.rest.dto.CheckDigitDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public class CheckDigitDao implements Dao<CheckDigitJpo> {


  @PersistenceContext(unitName = "isoEntityManager")
  private EntityManager em;

  @Override
  public long add(CheckDigitJpo checkDigitJpo) {
    em.persist(checkDigitJpo);
    em.flush();
    return checkDigitJpo.getId();
  }

  @Override
  public <T> List<T> getAll(Class<T> t) {
    String sqlquery = String.format("select e from %s e", t.getSimpleName());
    TypedQuery<T> query = em.createQuery(sqlquery, t);
    return query.getResultList();
  }

  @Override
  public void delete(Integer id) {
    CheckDigitJpo checkDigitJpo = em.find(CheckDigitJpo.class, id);
    if(checkDigitJpo != null){
      em.remove(checkDigitJpo);
      em.flush();
    }

  }

  @Override
  public void update(CheckDigitDto checkDigitDto) {
    CheckDigitJpo checkDigitJpo = em.find(CheckDigitJpo.class, checkDigitDto.getId());
    checkDigitJpo.setDigit(checkDigitDto.getText());
    em.merge(checkDigitJpo);
    em.flush();
  }

}
