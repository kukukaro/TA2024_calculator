import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class IsNegativeTest extends BaseCalculatorTest{

    public static Stream<Arguments> negativeTestArguments() {
        return Stream.of(
                Arguments.of(-500009, true),
                Arguments.of(-59, true),
                Arguments.of(-50000000000009L, true),
                Arguments.of( 500009, false),
                Arguments.of( 59, false),
                Arguments.of(-1, true),
                Arguments.of(1, false),
                Arguments.of(0, false)
        );
    }

    @ParameterizedTest
    @MethodSource("negativeTestArguments")
    @DisplayName("Check isNegative method")
    public void isNegativeTest(long argument, boolean result){
        assertEquals(result, calculator.isNegative(argument));
    }
}
