package implementations;

import interfaces.AsciiEncoder;

public class AsciiEncoderImpl implements AsciiEncoder {

    @Override
    public String encode(String originalText) {

        StringBuilder textInBinary = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            int ascii = originalText.charAt(i);
            int remainder;
            StringBuilder charInBinary = new StringBuilder();
            do {
                remainder = ascii % 2;
                charInBinary.append(remainder);
                ascii = ascii / 2;
            } while (ascii != 1);
            charInBinary.append(1);
            textInBinary.append(reverseString(charInBinary.toString()));
        }
        return textInBinary.toString();
    }

    public String reverseString(String charToBinary) {
        StringBuilder binaryChar = new StringBuilder();
        for (int i = charToBinary.length() - 1; i >= 0; i--) {
            binaryChar.append(charToBinary.charAt(i));
        }
        return binaryChar.toString();
    }

    @Override
    public String decode(String binary) {

        StringBuilder toAsciiFromBinary = new StringBuilder();
        int index1 = 0;
        int index2 = 7;
        int value;
        for (int i = 0; i < binary.length() / 7; i++) {
            value = 0;
            String asciiBits = binary.substring(index1, index2);
            int exponent = 6;
            for (int n = 0; n < asciiBits.length(); n++) {
                if (asciiBits.charAt(n) == '1') {
                    value += Math.pow(2, exponent);
                }
                exponent--;
            }
            index1 += 7;
            index2 += 7;
            toAsciiFromBinary.append((char) value);
        }
        return toAsciiFromBinary.toString();
    }
}