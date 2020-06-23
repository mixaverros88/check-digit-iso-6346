package com.verros.rest.common;

import com.verros.rest.common.CheckDigit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckDigit_Test {

  @Test
  public void CheckDigit_test_1() {
    CheckDigit checkDigit = new CheckDigit();
    assertEquals(checkDigit.verify("CSQU3054383"), true);
  }
}
