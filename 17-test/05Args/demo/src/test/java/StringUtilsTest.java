import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.StringUtils;

public class StringUtilsTest {
    @ParameterizedTest
    @MethodSource
    // @CsvSource({ "abc, Abc", "APPLE, Apple", "gooD, Good" })
    void testCapitalize(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }

    static List<Arguments> testCapitalize() {
        return List.of(
                Arguments.of("a", "A"),
                Arguments.of("APPLE", "Apple"),
                Arguments.of("abC", "Abc"));
    }
}
