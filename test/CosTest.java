import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class CosTest extends BaseCalculatorTest {


    public static Stream<Arguments> cosTestArgument() {
        return Stream.of(
                Arguments.of(45, 0.5253219888177297),
                Arguments.of(1, 0.5403023058681398),
                Arguments.of(-1, 0.5403023058681398)
        );


    }

    @ParameterizedTest
    @MethodSource("cosTestArgument")
    @DisplayName("Check cosinus method")
    public void cosTest(double argument, double result) {
        assertEquals(result, calculator.cos(argument));
    }

}
