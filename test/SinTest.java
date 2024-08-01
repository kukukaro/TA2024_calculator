import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class SinTest extends BaseCalculatorTest {


    public static Stream<Arguments> sinTestArguments() {
        return Stream.of(
                Arguments.of(-5, 0.9589242746631385),
                Arguments.of(-5.9, 0.373876664830236),
                Arguments.of(0,0),
                Arguments.of(1, 0.8414709848078965)
        );
    }

    @ParameterizedTest
    @MethodSource("sinTestArguments")
    @DisplayName("Check sinus method")
    public void sinTest(double argument, double result){
        assertEquals(result, calculator.sin(argument));
    }
}
