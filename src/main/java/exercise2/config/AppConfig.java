package exercise2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "exercise2.beans")
@Configuration
public class AppConfig {
}
