import implementations.BCDEncoderImpl;
import interfaces.BCDEncoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BCDEncoderTest {
    @Test
    public void testDecode() {
        BCDEncoder encoder = new BCDEncoderImpl();
        int result = encoder.decode("010110000100");
        assertEquals(584, result);
    }

    @Test
    public void testDecodeWithInvalidLength() {
        BCDEncoder encoder = new BCDEncoderImpl();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> encoder.decode("0110100"));
        assertEquals("Only 4 bits binary numbers are supported", exception.getMessage());
    }

    @Test
    public void testDecodeWithStringWithChars() {
        BCDEncoder encoder = new BCDEncoderImpl();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> encoder.decode("test"));
        assertEquals("Only binary numbers are supported", exception.getMessage());
    }

    @Test
    public void testEncode() {
        BCDEncoder encoder = new BCDEncoderImpl();
        String result = encoder.encode(584);
        assertEquals("010110000100", result);
    }

    @Test
    public void testEncodeNegativeNumber() {
        BCDEncoder encoder = new BCDEncoderImpl();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> encoder.encode(-1));
        assertEquals("Negative numbers are not supported", exception.getMessage());
    }
}
