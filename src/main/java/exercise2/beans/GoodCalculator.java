package exercise2.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("good")
public class GoodCalculator implements Calculator {
    public int calculate(int input1, int input2, String operator) {
        if ("*".equals(operator)) {
            return input1 * input2;
        } else if ("/".equals(operator)) {
            return input1 / input2;
        } else if ("+".equals(operator)) {
            return input1 + input2;
        } else if ("-".equals(operator)) {
            return input1 - input2;
        } else if ("sqrt".equals(operator)) {
            return (int) Math.sqrt(input1);
        }else if ("^".equals(operator)) {
            return (int) Math.pow(input1, input2);
        } else {
            return 0;
        }
    }
}
