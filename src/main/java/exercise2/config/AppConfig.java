package exercise2.config;

import exercise2.Beans.GoodCalculator;
import exercise2.Beans.InputParserBean;
import exercise2.Beans.Calculator;
import exercise2.Beans.WrongCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:profile.properties")
public class AppConfig {

    @Value("${calculator.current}") String currentProfile;

    @Bean
    public Calculator calculatorBean() {
        if(currentProfile.equals("good")) {
            return new GoodCalculator();
        }
        return new WrongCalculator();
    }

    @Bean
    public InputParserBean inputParserBean(Calculator calculator) {
        return new InputParserBean(calculator);
    }
}
