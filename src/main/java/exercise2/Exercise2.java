package exercise2;

import exercise2.Beans.InputParserBean;
import exercise2.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        InputParserBean parser = ctx.getBean(InputParserBean.class);
        parser.calculate();
    }
}
