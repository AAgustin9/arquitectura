import implementations.CalculatorImpl;
import interfaces.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    public void testSum() {
        Calculator calculator = new CalculatorImpl();
        String result = calculator.sum("1100", "1010");
        assertEquals("10110", result);
    }

    @Test
    public void testNonBinarySum() {
        Calculator calculator = new CalculatorImpl();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.sum("1100X", "1010"));
        assertEquals("Only binary numbers are supported", exception.getMessage());
    }

    @Test
    public void testSumDifferentLength() {
        Calculator calculator = new CalculatorImpl();
        String result = calculator.sum("1100", "101");
        assertEquals("10001", result);
    }

    @Test
    public void testSub() {
        Calculator calculator = new CalculatorImpl();
        String result = calculator.sub("11111111", "10110010");
        assertEquals("01001101", result);
    }

    @Test
    public void testNonBinarySub() {
        Calculator calculator = new CalculatorImpl();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.sub("1100X", "1010"));
        assertEquals("Only binary numbers are supported", exception.getMessage());
    }

    @Test
    public void testSubDifferentLenght() {
        Calculator calculator = new CalculatorImpl();
        String result = calculator.sub("11111111", "010110010");
        assertEquals("001001101", result);
    }

    @Test
    public void testToHexDifferentLength() {
        Calculator calculator = new CalculatorImpl();
        String result = calculator.toHex("0111001001");
        assertEquals("1C9", result);
    }

    @Test
    public void testToHexNormal() {
        Calculator calculator = new CalculatorImpl();
        String result = calculator.toHex("000111001001");
        assertEquals("1C9", result);
    }

    @Test
    public void testFromHexNormal() {
        Calculator calculator = new CalculatorImpl();
        String result = calculator.fromHex("1C9");
        assertEquals("000111001001", result);
    }
}
