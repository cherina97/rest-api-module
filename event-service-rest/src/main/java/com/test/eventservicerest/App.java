package com.test.eventservicerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.test.eventservicedto")
@ComponentScan({"com.test.eventserviceimpl", "com.test.eventservicerest"})
@EnableJpaRepositories("com.test.eventserviceimpl")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
