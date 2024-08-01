import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
class SumLongTest extends BaseCalculatorTest {

    public static Stream<Arguments> sumTestArguments() {
        return Stream.of(
                Arguments.of(3L, 4L, 7L),
                Arguments.of(200000L, 20000000005L, 20000200005L)
        );
    }

    public static Stream<Arguments> sumNegativeTestArguments() {
        return Stream.of(
                Arguments.of(-3,-3, -6),
                Arguments.of(-200000L, -20000000005L, -20000200005L)
        );
    }

    public static Stream<Arguments> sumNegativeAndPositiveTestArguments() {
        return Stream.of(
                Arguments.of(-5,5,0),
                Arguments.of(200000L, -20000000200005L, -20000000000005L)
        );
    }


    @ParameterizedTest
    @MethodSource("sumTestArguments")
    @DisplayName("Check the sum of two positive value")
    public void SumTest(long argument1, long argument2, long expectedValue) {
        assertEquals(expectedValue, calculator.sum(argument1, argument2));
    }


    @ParameterizedTest
    @MethodSource("sumNegativeTestArguments")
    @DisplayName("Check the sum of two negative value")
    public void SumNegativeTest(long argument1, long argument2, long expectedValue) {
        assertEquals(expectedValue, calculator.sum(argument1, argument2));
    }

    @ParameterizedTest
    @MethodSource("sumNegativeAndPositiveTestArguments")
    @DisplayName("Check the sum of one positive and one negative value")
    public void SumNegativeAndPositiveValueTest(long argument1, long argument2, long expectedValue) {
        assertEquals(expectedValue, calculator.sum(argument1, argument2));
    }


}