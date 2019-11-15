package exercise2.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputParserBean {

    private Calculator calculator;

    @Autowired
    public InputParserBean(Calculator calculator) {
        this.calculator = calculator;
    }

    public int calculate() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Select a first number: ");
        int input1 = scanner.nextInt();
        System.out.print("Select a second number: ");
        int input2 = scanner.nextInt();
        System.out.println("Select one of the following [*,/,+,-]");
        String operation = scanner.next();

        return calculator.calcultate(input1, input2, operation);

    }
}
