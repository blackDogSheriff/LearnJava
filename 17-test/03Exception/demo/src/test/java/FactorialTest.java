import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.example.Factorial;

public class FactorialTest {
    @Test
    public void testNegative() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.fact(-1));
    }

    @Test
    public void testNegative1() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Factorial.fact(-1);
            }
        });
    }
}
