import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class PowTest extends BaseCalculatorTest{

    public static Stream<Arguments> powTestArguments() {
        return Stream.of(
                Arguments.of(-3, 3, -27),
                Arguments.of(4, 0, 1),
                Arguments.of(0.999, 0.999, 1),
                Arguments.of(-3.8888, -0.888, -0.25714873482822465)
        );
    }

    @ParameterizedTest
    @MethodSource("powTestArguments")
    @DisplayName("Verify the power method")
    public void powTest(double argument1, double argument2, double result){
        assertEquals(result, calculator.pow(argument1, argument2));
    }
}
