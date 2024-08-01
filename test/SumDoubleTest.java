import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class SumDoubleTest extends BaseCalculatorTest {

    public static Stream<Arguments> sumDoubleTest() {
        return Stream.of(
                Arguments.of(0.000000000007, 0.0000000000087, 0.0000000000157),
                Arguments.of(0.0000000000999, 0.00000000000001, 0.00000000009991),
                Arguments.of(0.6, 0.5505, 1.1505)
        );
    }

    public static Stream<Arguments> sumDoubleNegativeTest() {
        return Stream.of(
                Arguments.of(-0.000000000007, -0.0000000000087, -0.0000000000157),
                Arguments.of(-0.0000000000999, -0.00000000000001, -0.00000000009991),
                Arguments.of(-0.6, -0.5505, -1.1505)
        );
    }

    public static Stream<Arguments> sumDoubleNegativeAndPositiveTest() {
        return Stream.of(
                Arguments.of(0.00000008, -0.0000000000009999, 7.99990001E-8),
                Arguments.of(-0.6, 0.5505, -0.04949999999999999)
        );
    }

    @ParameterizedTest
    @MethodSource("sumDoubleTest")
    @DisplayName("Check the sum of positive values")
    public void SumDoubleTest(double argument1, double argument2, double expectedValue) {
        assertEquals(expectedValue, calculator.sum(argument1, argument2));
    }

    @ParameterizedTest
    @MethodSource("sumDoubleNegativeTest")
    @DisplayName("Check the sum of negative values")
    public void SumDoubleNegativeTest(double argument1, double argument2, double expectedValue) {
        assertEquals(expectedValue, calculator.sum(argument1, argument2));
    }

    @ParameterizedTest
    @MethodSource("sumDoubleNegativeAndPositiveTest")
    @DisplayName("Check the sum of one positive and one negative value")
    public void SumDoubleNegativeAndPositiveValueTest(double argument1, double argument2, double expectedValue) {
        assertEquals(expectedValue, calculator.sum(argument1, argument2));
    }
}
