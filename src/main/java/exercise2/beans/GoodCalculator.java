package exercise2.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("good")
public class GoodCalculator implements Calculator {
    public int sum(int input1, int input2) {
        return input1 + input2;
    }
}
