//import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeEach;

public class BaseCalculatorTest {
    protected Calculator calculator;

    @BeforeEach
    public void initTest() {
        calculator = new Calculator();
    }
}
