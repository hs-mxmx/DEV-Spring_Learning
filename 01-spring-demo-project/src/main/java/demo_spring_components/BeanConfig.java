package demo_spring_components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo_spring_components")
public class BeanConfig {

    @Bean
    public Nurse nurse() {
        return new Nurse();
    }

    @Bean
    public Computer computer() {
        return new Computer();
    }

}
