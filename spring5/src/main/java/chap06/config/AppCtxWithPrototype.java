package chap06.config;

import chap06.spring.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class AppCtxWithPrototype {

    @Bean
    @Scope("prototype")
    public Client client() {
        Client client = new Client();
        client.setHost("host");
        return client;
    }
}
