package implementations;

import interfaces.Calculator;

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

    @Override
    public String toHex(String binary) {
        return null;
    }

    @Override
    public String fromHex(String hex) {
        return null;
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
