package com.verros.rest.process;

import com.verros.rest.common.CheckDigit;
import com.verros.rest.dto.CheckDigitDto;

public class BusinessProcess {

  public Boolean validate(CheckDigitDto checkDigitDto){
    CheckDigit checkDigit = new CheckDigit();
    return checkDigit.verify(checkDigitDto.getText());
  }

}
