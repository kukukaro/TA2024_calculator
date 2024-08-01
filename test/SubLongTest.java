import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class SubLongTest extends BaseCalculatorTest {
    public static Stream<Arguments> subTestArguments() {
        return Stream.of(
                Arguments.of(3L, 4L, -1L),
                Arguments.of(200000L, 20000000005L, -19999800005L)
        );
    }

    public static Stream<Arguments> subNegativeTestArguments() {
        return Stream.of(
                Arguments.of(-3,-3, 0),
                Arguments.of(-200000L, -20000000005L, 19999800005L)
        );
    }

    public static Stream<Arguments> subNegativeAndPositiveTestArguments() {
        return Stream.of(
                Arguments.of(-5,5,-10),
                Arguments.of(5,-5, 10),
                Arguments.of(200000L, -20000000200005L, 20000000400005L)
        );
    }


    @ParameterizedTest
    @MethodSource("subTestArguments")
    @DisplayName("Check the subtraction of two positive value")
    public void SubTest(long argument1, long argument2, long expectedValue) {
        assertEquals(expectedValue, calculator.sub(argument1, argument2));
    }


    @ParameterizedTest
    @MethodSource("subNegativeTestArguments")
    @DisplayName("Check the subtraction of two negative value")
    public void SumNegativeTest(long argument1, long argument2, long expectedValue) {
        assertEquals(expectedValue, calculator.sub(argument1, argument2));
    }

    @ParameterizedTest
    @MethodSource("subNegativeAndPositiveTestArguments")
    @DisplayName("Check the subtraction of one positive and one negative value")
    public void SubNegativeAndPositiveValueTest(long argument1, long argument2, long expectedValue) {
        assertEquals(expectedValue, calculator.sub(argument1, argument2));
    }
}
