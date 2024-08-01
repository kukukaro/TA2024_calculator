import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqrtTest extends BaseCalculatorTest{

    public static Stream<Arguments> sqrtTestArgument() {
        return Stream.of(
                Arguments.of(1,1),
                Arguments.of(-1.9, 1.378404875209022),
                Arguments.of(0,0),
                Arguments.of(-81, 9),
                Arguments.of(100, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("sqrtTestArgument")
    @DisplayName("Verify sqrt method")
    public void sqrtTest(double argument, double result){
        assertEquals(result, calculator.sqrt(argument));
    }
}
