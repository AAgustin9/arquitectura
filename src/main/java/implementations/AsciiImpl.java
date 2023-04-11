package implementations;

import interfaces.AsciiEncoder;

public class AsciiImpl implements AsciiEncoder {

        @Override
        public String encode(String originalText) {

            String textInBinary = "";
            for (int i = 0; i < originalText.length(); i++) {
                int ascii = (int) originalText.charAt(i);
                int remainder = 0;
                String charInBinary = "";
                do {
                    remainder = ascii % 2;
                    charInBinary += remainder;
                    ascii = ascii / 2;
                }while (ascii != 1);
                charInBinary = charInBinary + 1;
                textInBinary += reverseString(charInBinary);
            }
            return textInBinary;
        }

        public String reverseString (String charToBinary){
            String binaryChar = "";
            for(int i = charToBinary.length()-1; i>=0; i--){
                binaryChar += charToBinary.charAt(i);
            }
            return binaryChar;
        }

        @Override
        public String decode(String binary) {

            String toAsciiFromBinary = "";
            int index1 = 0;
            int index2 = 7;
            int value = 0;
            for (int i=0; i<binary.length()/7 ; i++) {
                value = 0;
                String asciiBits = binary.substring(index1, index2);
                int exponent = 6;
                for (int n = 0; n < asciiBits.length(); n++) {
                    if (asciiBits.charAt(n) == '1') {
                        value += Math.pow(2,exponent);
                    }
                    exponent --;
                }
                index1 += 7;
                index2 += 7;
                toAsciiFromBinary += (char) value;
            }
            return toAsciiFromBinary;
        }
    }
