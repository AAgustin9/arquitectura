package implementations;

import interfaces.BCDEncoder;

public class BCDEncoderImpl implements BCDEncoder {
    @Override
    public String encode(int a) {
        if (a < 0) throw new IllegalArgumentException("Negative numbers are not supported");
        StringBuilder result = new StringBuilder();
        String number = Integer.toString(a);
        for (int i = 0; i < number.length(); i++) {
            result.append(intToBCD(number.charAt(i)));
        }
        return result.toString();
    }

    @Override
    public int decode(String a) {
        unsupportedBinary(a);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i += 4) {
            result.append(fourBitsBinaryToBCD(a.substring(i, i + 4)));
        }
        return Integer.parseInt(result.toString());
    }

    private void unsupportedBinary(String a) {
        if (a.length() % 4 != 0) throw new IllegalArgumentException("Only 4 bits binary numbers are supported");
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '0' && a.charAt(i) != '1') {
                throw new IllegalArgumentException("Only binary numbers are supported");
            }
        }
    }

    private String fourBitsBinaryToBCD(String binary) {
        int result = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                result += Math.pow(2, binary.length() - i - 1);
            }
        }
        return String.valueOf(result);
    }

    private String intToBCD(Character a) {
        int number = Character.getNumericValue(a);
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            result.insert(0, (number % 2));
            number /= 2;
        }
        if (result.length() < 4) {
            while (result.length() < 4) {
                result.insert(0, "0");
            }
        }
        return result.toString();
    }
}
