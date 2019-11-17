package exercise2.beans;

import exercise2.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Profile("good")
public class GoodCalculator implements Calculator {

    private HistoryRepository historyRepository;

    @Autowired
    public GoodCalculator(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

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
            return Math.sin(radians);
        } else if ("cos".equals(operator)) {
            double radians = Math.toRadians((double) input1);
            return Math.cos(radians);
        } else if ("tan".equals(operator)) {
            double radians = Math.toRadians((double) input1);
            return Math.tan(radians);
        } else if ("log".equals(operator)) {
            return Math.log(input1);
        } else {
            return 0;
        }
    }

    public void rememberCalculation(int input1, int input2, String operator) {
        double answer = calculate(input1, input2, operator);
        String solution = input1 + operator + input2;
        historyRepository.storeCalculation(solution, answer);
    }

    public Map<String, Double> calcHistory() {
        return historyRepository.getCalcHistory();
    }
}
