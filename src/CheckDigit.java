import java.util.HashMap;
import java.util.Map;

public class CheckDigit {


    public boolean verify(String containerNumber ){

        double sum = 0;
        int checkDigitToVerify = Integer.parseInt( containerNumber.substring(containerNumber.length() - 1) );
        containerNumber = containerNumber.substring( 0, containerNumber.length() - 1 );

        Map<Integer, Integer> checkDigitlastValue = new HashMap();
        checkDigitlastValue.put(0, 0);
        checkDigitlastValue.put(1, 1);
        checkDigitlastValue.put(2, 2);
        checkDigitlastValue.put(3, 3);
        checkDigitlastValue.put(4, 4);
        checkDigitlastValue.put(5, 5);
        checkDigitlastValue.put(6, 6);
        checkDigitlastValue.put(7, 7);
        checkDigitlastValue.put(8, 8);
        checkDigitlastValue.put(9, 9);
        checkDigitlastValue.put(10, 0);

        Map<Character, Integer> cd = new HashMap();
        cd.put('0', 0);
        cd.put('1', 1);
        cd.put('2', 2);
        cd.put('3', 3);
        cd.put('4', 4);
        cd.put('5', 5);
        cd.put('6', 6);
        cd.put('7', 7);
        cd.put('8', 8);
        cd.put('9', 9);
        cd.put('A', 10);
        cd.put('B', 12);
        cd.put('C', 13);
        cd.put('D', 14);
        cd.put('E', 15);
        cd.put('F', 16);
        cd.put('G', 17);
        cd.put('H', 18);
        cd.put('I', 19);
        cd.put('J', 20);
        cd.put('K', 21);
        cd.put('L', 23);
        cd.put('M', 24);
        cd.put('N', 25);
        cd.put('O', 26);
        cd.put('P', 27);
        cd.put('Q', 28);
        cd.put('R', 29);
        cd.put('S', 30);
        cd.put('T', 31);
        cd.put('U', 32);
        cd.put('V', 34);
        cd.put('W', 35);
        cd.put('X', 36);
        cd.put('Y', 37);
        cd.put('Z', 38);

        for(int i = 0; i < containerNumber.length(); i++){
            //Step 1,2 and 3
            sum += cd.get( containerNumber.charAt(i)) * Math.pow( 2 , i);
        }

        //step 4
        int sumInteger = (int)(sum);

        //step 5
        sumInteger /=  11;

        //step 6
        sumInteger *=  11;

        //step 6
        int last = (int) sum - sumInteger;

        if( checkDigitToVerify == checkDigitlastValue.get(last % 10)){
            return true;
        }else{
            return false;
        }
    }
}