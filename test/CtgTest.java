import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class CtgTest extends BaseCalculatorTest{

    public static Stream<Arguments> cotangentTestArguments() {
        return Stream.of(
                Arguments.of(0.1, 9.966644423259238),
                Arguments.of(-1, 	-0.6420926159343308)
        );
    }

    @ParameterizedTest
    @MethodSource("cotangentTestArguments")
    @DisplayName("Check cotangent method")
    public void cotangentTest(double argument, double result){
        assertEquals(result, calculator.ctg(argument));
    }
}
