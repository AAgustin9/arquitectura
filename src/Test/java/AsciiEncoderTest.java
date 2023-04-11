import implementations.AsciiImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AsciiEncoderTest {

    AsciiImpl myASCIIEncoder = new AsciiImpl();
    String stringTest = "1000001";
    String stringTest2 = "11000011100010";
    String stringTest3 = "11010001100101110110011011001101111";

    String binaryTest = "A";
    String binaryTest2 = "ab";
    String binaryTest3 = "hello";

    @Test
    void encode() {
        assertEquals(stringTest, myASCIIEncoder.encode(binaryTest));
        assertEquals(stringTest2, myASCIIEncoder.encode(binaryTest2));
        assertEquals(stringTest3, myASCIIEncoder.encode(binaryTest3));
    }

    @Test
    void decode() {
        assertEquals(binaryTest, myASCIIEncoder.decode(stringTest));
        assertEquals(binaryTest2, myASCIIEncoder.decode(stringTest2));
        assertEquals(binaryTest3, myASCIIEncoder.decode(stringTest3));

    }
}
