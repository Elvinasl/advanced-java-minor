package exercise2.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("good")
public class GoodCalculator implements Calculator {
    public double calculate(int input1, int input2, String operator) {
        if ("*".equals(operator)) {
            return input1 * input2;
        } else if ("/".equals(operator)) {
            return input1 / input2;
        } else if ("+".equals(operator)) {
            return input1 + input2;
        } else if ("-".equals(operator)) {
            return input1 - input2;
        } else if ("sqrt".equals(operator)) {
            return Math.sqrt(input1);
        } else if ("^".equals(operator)) {
            return Math.pow(input1, input2);
        } else if ("sin".equals(operator)) {
            double radians = Math.toRadians((double) input1);
            System.out.println("The value of pi is " + Math.PI);
            return Math.sin(radians);
        } else {
            return 0;
        }
    }
}
