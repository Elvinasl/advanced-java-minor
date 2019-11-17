package exercise2;

import exercise2.beans.InputParserBean;
import exercise2.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Exercise2 {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        while (true) {
            InputParserBean parser = ctx.getBean(InputParserBean.class);
            double result = parser.calculate();

            System.out.println("Result: " + result);
            System.out.println("Calculations history: " + parser.getCalcHistory());
        }
    }
}
