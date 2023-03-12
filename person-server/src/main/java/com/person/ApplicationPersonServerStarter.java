package com.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.person.db.model")
@EnableJpaRepositories(basePackages = "com.person.db.repository")
public class ApplicationPersonServerStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationPersonServerStarter.class, args);
    }
}
