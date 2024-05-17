package kata.lawnmower.app.config;

import kata.lawnmower.app.adapters.TextFileAdapter;
import kata.lawnmower.app.adapters.impl.TextFileAdapterImpl;
import kata.lawnmower.domain.service.LawnMowerService;
import kata.lawnmower.domain.service.impl.LawnMowerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public LawnMowerService lawnMowerService() {
        return new LawnMowerServiceImpl();
    }
    @Bean
    public TextFileAdapter textFileAdapter() {
        return new TextFileAdapterImpl(lawnMowerService());
    }

}
