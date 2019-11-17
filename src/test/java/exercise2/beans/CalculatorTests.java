package exercise2.beans;

import exercise2.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CalculatorTests {

    @Autowired
    private Calculator wrongCalculator;

    @Test
    public void testBadCalculator() {
        // TODO: ask. Tests are not working for some reason...
        double result = wrongCalculator.calculate(1, 2, "+");
//        assertThat(result, -1);
    }
}
