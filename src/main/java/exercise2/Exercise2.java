package exercise2;

import exercise2.beans.InputParserBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Exercise2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("exercise2.beans");

        while (true) {
            InputParserBean parser = ctx.getBean(InputParserBean.class);
            int result = parser.calculate();

            System.out.println("Result: " + result);
        }
    }
}
