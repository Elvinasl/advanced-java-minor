package resources;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import webshop.config.DatabaseConfig;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "webshop.data")
@EnableTransactionManagement
@Import(DatabaseConfig.class)
public class TestApplicationContext {

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .build();
    }
}

