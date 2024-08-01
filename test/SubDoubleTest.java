import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class SubDoubleTest extends BaseCalculatorTest {
    public static Stream<Arguments> subDoubleTest() {
        return Stream.of(
                Arguments.of(0.000000000007, 0.0000000000087, -1.6999999999999996E-12),
                Arguments.of(0.0000000000999, 0.00000000000001, 9.989E-11),
                Arguments.of(0.6, 0.5505, 0.04949999999999999)
        );
    }

    public static Stream<Arguments> subDoubleNegativeTest() {
        return Stream.of(
                Arguments.of(-0.000000000007, -0.0000000000087, 1.6999999999999996E-12),
                Arguments.of(-0.0000000000999, -0.00000000000001, -9.989E-11),
                Arguments.of(-0.6, -0.5505, -0.04949999999999999)
        );
    }

    public static Stream<Arguments> subDoubleNegativeAndPositiveTest() {
        return Stream.of(
                Arguments.of(0.00000008, -0.0000000000009999, 8.000099990000001E-8),
                Arguments.of(-0.6, 0.5505, -1.1505)
        );
    }

    @ParameterizedTest
    @MethodSource("subDoubleTest")
    @DisplayName("Check the subtraction of positive values")
    public void SubDoubleTest(double argument1, double argument2, double expectedValue) {
        assertEquals(expectedValue, calculator.sub(argument1, argument2));
    }

    @ParameterizedTest
    @MethodSource("subDoubleNegativeTest")
    @DisplayName("Check the subtraction of negative values")
    public void SubDoubleNegativeTest(double argument1, double argument2, double expectedValue) {
        assertEquals(expectedValue, calculator.sub(argument1, argument2));
    }

    @ParameterizedTest
    @MethodSource("subDoubleNegativeAndPositiveTest")
    @DisplayName("Check the subtraction of one positive and one negative value")
    public void SubDoubleNegativeAndPositiveValueTest(double argument1, double argument2, double expectedValue) {
        assertEquals(expectedValue, calculator.sub(argument1, argument2));
    }
}
