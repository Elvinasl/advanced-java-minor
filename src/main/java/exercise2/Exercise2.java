package exercise2;

import exercise2.beans.InputParserBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("exercise2.beans");

        InputParserBean parser = ctx.getBean(InputParserBean.class);
        parser.calculate();
    }
}
