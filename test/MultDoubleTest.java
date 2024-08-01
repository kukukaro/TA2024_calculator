import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultDoubleTest extends BaseCalculatorTest {


    public static Stream<Arguments> multiDoublePositiveTestArguments() {
        return Stream.of(
                Arguments.of(25.0009, 36.9099, 922.78071891 ),
                Arguments.of(9.06559, 0, 0),
                Arguments.of(8, 8.888888, 71.111104)

        );
    }

    public static Stream<Arguments> multiDoubleNegativeTestArguments() {
        return Stream.of(
                Arguments.of(-25.0009, -36.9099, 922.78071891 ),
                Arguments.of(-9.06559, -0.0, 0.0),
                Arguments.of(-8, -8.888888, 71.111104)

        );
    }

    public static Stream<Arguments> multiDoubleNegativeAndPositiveTestArguments() {
        return Stream.of(
                Arguments.of(-25.0009, 36.9099, -922.78071891 ),
                Arguments.of(-9.06559, 0.0, -0.0),
                Arguments.of(8, -8.888888, -71.111104)

        );
    }

    @ParameterizedTest
    @MethodSource("multiDoublePositiveTestArguments")
    @DisplayName("Check multiplying of double positive")
    public void multiDoublePositiveTest(double argument1, double argument2, double result){
        assertEquals(result, calculator.mult(argument1,argument2));
    }

    @ParameterizedTest
    @MethodSource("multiDoubleNegativeTestArguments")
    @DisplayName("Check multiplying of double negative")
    public void multiDoubleNegativeTest(double argument1, double argument2, double result){
        assertEquals(result, calculator.mult(argument1,argument2));
    }

    @ParameterizedTest
    @MethodSource("multiDoubleNegativeAndPositiveTestArguments")
    @DisplayName("Check multiplying of double one negative and one positive")
    public void multiDoubleNegativeAndPositiveTest(double argument1, double argument2, double result){
        assertEquals(result, calculator.mult(argument1,argument2));
    }

}
