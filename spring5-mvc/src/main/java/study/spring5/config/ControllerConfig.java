package study.spring5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.spring5.controller.HelloController;
import study.spring5.controller.RegisterController;

@Configuration
public class ControllerConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public RegisterController registerController() {
        return new RegisterController();
    }
}
