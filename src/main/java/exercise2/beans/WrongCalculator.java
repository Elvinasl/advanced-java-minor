package exercise2.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("wrong")
public class WrongCalculator implements Calculator {
    public int sum(int input1, int input2) {
        return 500000;
    }
}
