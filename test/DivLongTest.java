import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class DivLongTest extends BaseCalculatorTest{


    public static Stream<Arguments> divideTestArguments() {
        return Stream.of(
                Arguments.of(1000000009, 907, 1102535),
                Arguments.of(-200041000000009L, 956347807L, -209171),
                Arguments.of(-9000000009L, -70239876, 128),
                Arguments.of(900, -30, -30)
        );
    }

    @ParameterizedTest
    @MethodSource("divideTestArguments")
    public void divideTest(long argument1, long argument2, long result) {
        assertEquals(result, calculator.div(argument1, argument2));
    }

    @Test
    public void divideByZeroTest() {
        Assertions.assertThrows(NumberFormatException.class, () -> calculator.div(100, 0));
    }
}
