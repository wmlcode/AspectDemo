package ru.lanit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.lanit.services.MyService;

@Configuration
public class Config {
    @Bean("service")
    MyService service() {
        MyService service = new MyService();
        return service;
    }
}
