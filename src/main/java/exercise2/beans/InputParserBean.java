package exercise2.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class InputParserBean {

    private Calculator calculator;
    private Set<String> singleNumberOperations = Stream.of("sqrt", "sin", "cos", "tan", "log")
                                                        .collect(Collectors.toCollection(HashSet::new));

    @Autowired
    public InputParserBean(Calculator calculator) {
        this.calculator = calculator;
    }

    public double calculate() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select one of the following [*, /, +, -, sqrt, ^, sin, cos, tan, log]");
        String operation = scanner.next();
        System.out.print("Select a first number: ");
        int input1 = scanner.nextInt();

        // if this operator requires only one number
        if(singleNumberOperations.contains(operation)) {
            return calculator.calculate(input1, -1, operation);
        }

        System.out.print("Select a second number: ");
        int input2 = scanner.nextInt();

        return calculator.calculate(input1, input2, operation);

    }
}
