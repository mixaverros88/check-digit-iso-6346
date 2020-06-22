package com.verros.ds;

import com.verros.ds.dao.CheckDigitDao;
import com.verros.ds.entities.CheckDigit;

import javax.inject.Inject;


public class DatabaseManagement {

  @Inject
  CheckDigitDao checkDigitDao;

  public void add(String digit) {
    CheckDigit checkDigit = new CheckDigit();
    checkDigit.setDigit(digit);
    checkDigitDao.add(checkDigit);
  }

}
