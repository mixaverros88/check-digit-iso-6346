package com.verros.common;

import java.util.HashMap;
import java.util.Map;

public class CheckDigit {

    /**
     * This method get a container Number, get rid the last number which is the check digit, generate the check digit
     * and validate if is correct.
     * @param containerNumber e.g. CSQU3054383
     * @return True if the check digit is the same unless false
     */
    public boolean verify(String containerNumber ){

        double sum = 0;
        // Get the last number of the container number which is the check digit.
        int checkDigitToVerify = Integer.parseInt( containerNumber.substring(containerNumber.length() - 1) );

        // Get rid of the last number, the last number is the check digit where we want to generated in order to validate.
        containerNumber = containerNumber.substring( 0, containerNumber.length() - 1 );

        Map<Integer, Integer> checkDigitLastValue = new HashMap();
        checkDigitLastValue.put(0, 0);
        checkDigitLastValue.put(1, 1);
        checkDigitLastValue.put(2, 2);
        checkDigitLastValue.put(3, 3);
        checkDigitLastValue.put(4, 4);
        checkDigitLastValue.put(5, 5);
        checkDigitLastValue.put(6, 6);
        checkDigitLastValue.put(7, 7);
        checkDigitLastValue.put(8, 8);
        checkDigitLastValue.put(9, 9);
        checkDigitLastValue.put(10, 0);

        Map<Character, Integer> equivalentNumericalValues = new HashMap();
        equivalentNumericalValues.put('0', 0);
        equivalentNumericalValues.put('1', 1);
        equivalentNumericalValues.put('2', 2);
        equivalentNumericalValues.put('3', 3);
        equivalentNumericalValues.put('4', 4);
        equivalentNumericalValues.put('5', 5);
        equivalentNumericalValues.put('6', 6);
        equivalentNumericalValues.put('7', 7);
        equivalentNumericalValues.put('8', 8);
        equivalentNumericalValues.put('9', 9);
        equivalentNumericalValues.put('A', 10);
        equivalentNumericalValues.put('B', 12);
        equivalentNumericalValues.put('C', 13);
        equivalentNumericalValues.put('D', 14);
        equivalentNumericalValues.put('E', 15);
        equivalentNumericalValues.put('F', 16);
        equivalentNumericalValues.put('G', 17);
        equivalentNumericalValues.put('H', 18);
        equivalentNumericalValues.put('I', 19);
        equivalentNumericalValues.put('J', 20);
        equivalentNumericalValues.put('K', 21);
        equivalentNumericalValues.put('L', 23);
        equivalentNumericalValues.put('M', 24);
        equivalentNumericalValues.put('N', 25);
        equivalentNumericalValues.put('O', 26);
        equivalentNumericalValues.put('P', 27);
        equivalentNumericalValues.put('Q', 28);
        equivalentNumericalValues.put('R', 29);
        equivalentNumericalValues.put('S', 30);
        equivalentNumericalValues.put('T', 31);
        equivalentNumericalValues.put('U', 32);
        equivalentNumericalValues.put('V', 34);
        equivalentNumericalValues.put('W', 35);
        equivalentNumericalValues.put('X', 36);
        equivalentNumericalValues.put('Y', 37);
        equivalentNumericalValues.put('Z', 38);

        // Step 1,2 and 3
        for(int i = 0; i < containerNumber.length(); i++){
            sum += equivalentNumericalValues.get( containerNumber.charAt(i)) * Math.pow( 2 , i);
        }

        // Step 4
        int sumInteger = (int)(sum);

        // Step 5
        sumInteger /=  11;

        // Step 6
        sumInteger *=  11;

        // Step 6
        int last = (int) sum - sumInteger;

        if( checkDigitToVerify == checkDigitLastValue.get(last % 10)){
            return true;
        }else{
            return false;
        }
    }
}