import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsPositiveTest extends BaseCalculatorTest{

    public static Stream<Arguments> positiveTestArguments() {
        return Stream.of(
                Arguments.of(-500009, false),
                Arguments.of(-59, false),
                Arguments.of(-50000000000009L, false),
                Arguments.of( 500009, true),
                Arguments.of( 59, true),
                Arguments.of(-1, false),
                Arguments.of(1, true),
                Arguments.of(0, false)
        );
    }

    @ParameterizedTest
    @MethodSource("positiveTestArguments")
    @DisplayName("Check isPositive method")
    public void isPositiveTest(long argument, boolean result){
        assertEquals(result, calculator.isPositive(argument));
    }
}

