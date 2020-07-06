package com.verros.ds.management;

import com.verros.ds.dao.CheckDigitDao;
import com.verros.ds.entities.CheckDigitJpo;
import com.verros.rest.dto.CheckDigitDto;

import javax.inject.Inject;
import java.util.List;


public class DatabaseManagement {

  @Inject
  CheckDigitDao checkDigitDao;

  public void add(String digit) {
    CheckDigitJpo checkDigitJpo = new CheckDigitJpo();
    checkDigitJpo.setDigit(digit);
    checkDigitDao.add(checkDigitJpo);
  }

  public List<CheckDigitJpo> getAll(){
    return checkDigitDao.getAll(CheckDigitJpo.class);
  }

  public void delete(Integer id){
    checkDigitDao.delete(id);
  }

  public void update(CheckDigitDto checkDigitDto){
    checkDigitDao.update(checkDigitDto);
  }

}
