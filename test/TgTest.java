import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TgTest extends BaseCalculatorTest {

    public static Stream<Arguments> tangentTestArgs() {
        return Stream.of(
                Arguments.of(-10.1, -0.8007893029375109),
                Arguments.of(-1, -1.557407724654902),
                Arguments.of(0, 0),
                Arguments.of(Math.PI, -1.2246467991473532E-16)
        );
    }

    @ParameterizedTest
    @MethodSource("tangentTestArgs")
    @DisplayName("Check tangent method")
    public void tangentTest(double argument, double result){
        assertEquals(result, calculator.tg(argument));
    }
}
