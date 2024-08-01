import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class MultLongTest extends BaseCalculatorTest {

  
    public static Stream<Arguments> multPositiveTestArguments() {
        return Stream.of(
                Arguments.of(30, 40, 1200),
                Arguments.of(200000L, 99999999, 19999999800000L),
                Arguments.of(9999999999999999L, 0, 0)
        );
    }

    public static Stream<Arguments> multNegativeTestArguments() {
        return Stream.of(
                Arguments.of(-30, -40, 1200),
                Arguments.of(-2000000, -99999999, 199999998000000L),
                Arguments.of(-9999999999999999L, 0, 0)
        );
    }

    public static Stream<Arguments> multNegativeAndPositiveTestArguments() {
        return Stream.of(
                Arguments.of(-30, 40, -1200),
                Arguments.of(-200000L, 99999999, -19999999800000L),
                Arguments.of(-9999999999999999L, 0, 0)
        );
    }


    @ParameterizedTest
    @MethodSource("multPositiveTestArguments")
    @DisplayName("Check the multiplying of two positive value")
    public void SubTest(long argument1, long argument2, long expectedValue) {
        assertEquals(expectedValue, calculator.mult(argument1, argument2));
    }


    @ParameterizedTest
    @MethodSource("multNegativeTestArguments")
    @DisplayName("Check the multiplying of two negative value")
    public void SumNegativeTest(long argument1, long argument2, long expectedValue) {
        assertEquals(expectedValue, calculator.mult(argument1, argument2));
    }

    @ParameterizedTest
    @MethodSource("multNegativeAndPositiveTestArguments")
    @DisplayName("Check the multiplying of one positive and one negative value")
    public void SubNegativeAndPositiveValueTest(long argument1, long argument2, long expectedValue) {
        assertEquals(expectedValue, calculator.mult(argument1, argument2));
    }
}
