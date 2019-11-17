package exercise2.beans;

import java.util.Map;

public interface Calculator {
    double calculate(int input1, int input2, String operator);
    void rememberCalculation(int input1, int input2, String operator);
    Map<String, Double> calcHistory();
}
