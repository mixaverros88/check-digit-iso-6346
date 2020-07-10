package com.verros.ds.management;

import com.verros.ds.dao.CheckDigitDao;
import com.verros.ds.entities.CheckDigitJpo;
import com.verros.rest.dto.CheckDigitDto;
import com.verros.rest.exception.BusinessException;

import javax.inject.Inject;
import java.util.List;


public class DatabaseManagement {

  @Inject
  CheckDigitDao checkDigitDao;

  public long add(String digit) {
    CheckDigitJpo checkDigitJpo = new CheckDigitJpo();
    checkDigitJpo.setDigit(digit);
    return checkDigitDao.add(checkDigitJpo);
  }

  public List<CheckDigitJpo> getAll(){
    return checkDigitDao.getAll(CheckDigitJpo.class);
  }

  public void delete(Integer id) throws BusinessException {
    if(id>0){
      checkDigitDao.delete(id);
    }else{
      throw new BusinessException("No valid id","BAD_REQUEST");
    }

  }

  public void update(CheckDigitDto checkDigitDto){
    checkDigitDao.update(checkDigitDto);
  }

}
