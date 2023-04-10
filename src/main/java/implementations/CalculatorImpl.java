package implementations;

import interfaces.Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorImpl implements Calculator {

    private String order(String a, String b) {
        // make both strings the same length
        String add = "";
        for (int i = 0; i < Math.abs(b.length() - a.length()); i++) {
            add += "0";
        }
        return add + a;
    }

    @Override
    public String sum(String a, String b) {

        if (a.length() < b.length()) a = order(a, b);
        if (a.length() > b.length()) b = order(b, a);

        String carry = "0";
        StringBuilder result = new StringBuilder();

        for (int i = a.length() - 1; i >= 0; i--) {
            if ((a.charAt(i) > b.charAt(i) || a.charAt(i) < b.charAt(i)) && carry.equals("0")) {
                result.append("1");
            } else if ((a.charAt(i) == b.charAt(i) && a.charAt(i) == '1') && carry.equals("0")) {
                result.append("0");
                carry = "1";
            } else if ((a.charAt(i) == b.charAt(i) && a.charAt(i) == '0') && carry.equals("0")) {
                result.append("0");
            } else if ((a.charAt(i) > b.charAt(i) || a.charAt(i) < b.charAt(i)) && carry.equals("1")) {
                result.append("0");
                carry = "1";
            } else if ((a.charAt(i) == b.charAt(i) && a.charAt(i) == '1') && carry.equals("1")) {
                result.append("1");
                carry = "1";
            } else if ((a.charAt(i) == b.charAt(i) && a.charAt(i) == '0') && carry.equals("1")) {
                result.append("1");
                carry = "0";
            }

        }
        if (carry == "1") return "1" + new StringBuilder(result.toString()).reverse();

        return new StringBuilder(result.toString()).reverse().toString();
    }

    @Override
    public String sub(String a, String b) {

        if (a.length() < b.length()) a = order(a, b);
        if (a.length() > b.length()) b = order(b, a);

        String complement = sum(complement(b), "1");
        if (complement.length() != a.length()) complement = complement.substring(1);
        String result = sum(a, complement);
        if (result.length() != a.length()) return result.substring(1);
        else return result;
    }

    @Override
    public String mult(String a, String b) {
        return null;
    }

    @Override
    public String div(String a, String b) {
        return null;
    }

    HashMap<String, String> binMap = new HashMap<>() {{
            put("0000", "0");
            put("0001", "1");
            put("0010", "2");
            put("0011", "3");
            put("0100", "4");
            put("0101", "5");
            put("0110", "6");
            put("0111", "7");
            put("1000", "8");
            put("1001", "9");
            put("1010", "A");
            put("1011", "B");
            put("1100", "C");
            put("1101", "D");
            put("1110", "E");
            put("1111", "F");
        }};

    @Override
    public String toHex(String binary) {
        String hexa = "";
        String ceros = "";
        List<String> separateList = new ArrayList<>();
        String orderedBinary = "";
        //Checks that the number can be separated in 4's.
        if (binary.length() % 4 !=0){
            int adders = 4 - binary.length() % 4; //finds the missing 0's.
            for (int i = 0; i < adders; i++) {
                ceros += "0";
            }
            orderedBinary = ceros + binary;
        }
        for (int i = 0; i < orderedBinary.length(); i+=4) {
            separateList.add(orderedBinary.substring(i, i+4));
        }

        for (String slice: separateList) {

            for (String key : binMap.keySet()) {
                if (key.equals(slice)) {
                    hexa += binMap.get(slice);
                }
            }
        }

        return hexa;
    }

    HashMap<Character, String> hexMap = new HashMap<>() {{
        put('0', "0000");
        put('1', "0001");
        put('2', "0010");
        put('3', "0011");
        put('4', "0100");
        put('5', "0101");
        put('6', "0110");
        put('7', "0111");
        put('8', "1000");
        put('9', "1001");
        put('A', "1010");
        put('B', "1011");
        put('C', "1100");
        put('D', "1101");
        put('E', "1110");
        put('F', "1111");
    }};

    @Override
    public String fromHex(String hex) {
        String bin = "";
        for (int i = 0; i < hex.length(); i++) {
            if (hexMap.containsKey(hex.charAt(i))){
                bin += hexMap.get(hex.charAt(i));
            }
        }
        return bin;
    }

    private String complement(String a) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0') {
                result.append("1");
            } else result.append("0");
        }
        return result.toString();
    }
}
