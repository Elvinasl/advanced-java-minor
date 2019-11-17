package exercise2.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile("wrong")
public class WrongCalculator implements Calculator {

    public double calculate(int input1, int input2, String operator) {
        return -1;
    }

    public void rememberCalculation(int input1, int input2, String operator) {
        System.out.println("I am stupid calculator. I cannot remember anything...");
    }

    public Map<String, Double> calcHistory() {
        return new HashMap<>();
    }
}
