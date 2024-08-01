import org.junit.jupiter.api.Assertions;
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
public class DivDoubleTest extends BaseCalculatorTest {

    public static Stream<Arguments> divideDoubleTestArguments() {
        return Stream.of(
                Arguments.of(2, -2, -1),
                Arguments.of(1250.39, 3.99, 313.38095238095238095238)
        );
    }

    @ParameterizedTest
    @MethodSource("divideDoubleTestArguments")
    @DisplayName("Check division method ")
    public void divDoubleTest(double argument1, double argument2, double result){
        assertEquals(result, calculator.div(argument1,argument2));

    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(NumberFormatException.class, () -> calculator.div(100, 0));
    }
}
