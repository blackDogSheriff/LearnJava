import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ArgsTest {
    @ParameterizedTest
    @ValueSource(ints = { -1, -2, -3 })
    public void testAbsNegative(int x) {
        assertEquals(-x, Math.abs(x));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    public void testAbs(int x) {
        assertEquals(x, Math.abs(x));
    }
}
