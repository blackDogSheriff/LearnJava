import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Calculater;

public class CalculatorTest {
    Calculater calculator;

    /*
     * 运行每个Test方法前启动
     */
    @BeforeEach
    public void setUp() {
        this.calculator = new Calculater();
    }

    /*
     * 运行每个Test方法后启动
     */
    @AfterEach
    public void tearDown() {
        this.calculator = null;
    }

    @Test
    public void testAdd() {
        assertEquals(100, this.calculator.add(100));
        assertEquals(150, this.calculator.add(50));
        assertEquals(130, this.calculator.add(-20));
    }

    @Test
    public void testSub() {
        assertEquals(-100, this.calculator.sub(100));
        assertEquals(-150, this.calculator.sub(50));
        assertEquals(-130, this.calculator.sub(-20));
    }
}
