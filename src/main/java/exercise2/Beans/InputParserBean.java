package exercise2.Beans;


import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputParserBean {

    private Calculator calculator;

    @Autowired
    public InputParserBean(Calculator calculator) {
        this.calculator = calculator;
    }

    private String getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public void calculate() throws IOException {
        int input1 = Integer.parseInt(getInput());
        int input2 = Integer.parseInt(getInput());

        int sum = calculator.sum(input1, input2);
        System.out.println(sum);
    }
}
